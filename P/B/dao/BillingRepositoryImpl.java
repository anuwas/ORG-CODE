package com.mes.ps.billing.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mes.ps.billing.dto.DailyJobStatusDto;
import com.mes.ps.billing.dto.MerchantPricing;
import com.mes.ps.billing.entity.CreditDebitTransaction;
import com.mes.ps.billing.entity.MbsDailySummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mes.ps.billing.dto.MonthlyBillingProcess;
import com.mes.ps.billing.util.DateTimeUtils;

import static com.mes.ps.billing.common.Constants.JOB_CREDITDEBIT_JDBC_STATEMENT_BATCH_SIZE;
import static com.mes.ps.billing.common.Constants.JOB_MONTHLY_JDBC_STATEMENT_BATCH_SIZE;

/**
 * Repository layer implementation for billing application
 */
@Repository
public class BillingRepositoryImpl implements BillingRepository {
  private static final Logger log = LoggerFactory.getLogger(BillingRepositoryImpl.class);
  @Value("${"+JOB_CREDITDEBIT_JDBC_STATEMENT_BATCH_SIZE+"}")
  private Integer creditDebitBatchSize;
  @Value("${"+JOB_MONTHLY_JDBC_STATEMENT_BATCH_SIZE+"}")
  private Integer monthlyJdbcBatchSize;

  private final Integer CREDIT_DEBIT_BATCH_SIZE = creditDebitBatchSize == null ? 200 : creditDebitBatchSize;
  
  private final Integer MONTHLY_JDBC_BATCH_SIZE = monthlyJdbcBatchSize == null ? 200 : monthlyJdbcBatchSize;

  private static final String QUERY_GET_MERCHANTS = "SELECT DISTINCT ENTITY_ID FROM ACHP_PROFILES WHERE ENTITY_ID IS NOT NULL ORDER BY ENTITY_ID";
  private static final String QUERY_GET_ACH_MBS_ELEMENTS = "SELECT ITEM_TYPE, STATEMENT_MSG_DEFAULT FROM MBS_ELEMENTS WHERE ITEM_TYPE IN (224,225,226)";
  private static final String QUERY_INSERT_CREDIT_DEBIT_RECORD = "INSERT INTO ACHPS_TRANSACTION_DETAIL (TRANSACTION_NUMBER, ENTITY_ID, LOCATION_ID, " +
      "EFFECTIVE_DATE, TRANSACTION_DATE, OPERATION_TYPE, AMOUNT, PROFILE_ID, REF_NUMBER) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
  private static final String QUERY_INSERT_ACHPS_BILLING_JOB_DETAIL = "INSERT INTO ACHPS_BILLING_JOB_DETAIL (JOB_ID, JOB_TYPE, "
      + "PARAM_BEGIN_DATE, PARAM_END_DATE, JOB_STATUS) VALUES (ACHPS_BILLING_JOB_SEQ.nextval, ?, ?, ?, ?)";
  private static final String QUERY_UPDATE_ACHPS_BILLING_JOB_DETAIL = "UPDATE ACHPS_BILLING_JOB_DETAIL SET JOB_STATUS = ? WHERE JOB_ID = ?";
  private static final String QUERY_GET_MERCHANT_PROFILE = "SELECT AP.MERCH_NUM, AP.ENTITY_ID, AP.LOCATION_ID, MP.ITEM_TYPE ," +
      "MP.PER_ITEM, MP.RATE, ME.STATEMENT_MSG_DEFAULT AS ITEM_DESC " +
      "FROM ACHP_PROFILES AP, MBS_PRICING MP, MBS_ELEMENTS ME " +
      "WHERE AP.MERCH_NUM = MP.MERCHANT_NUMBER AND ME.ITEM_TYPE = MP.ITEM_TYPE AND MP.ITEM_SUBCLASS = 'AC' " +
      "AND MP.VALID_DATE_END >= CURRENT_DATE AND AP.ENTITY_ID IS NOT NULL";
  private static final String QUERY_INSERT_MBS_DAILY_SUMMARY = "INSERT INTO MBS_DAILY_SUMMARY (REC_ID, MERCHANT_NUMBER, ACTIVITY_DATE, ITEM_TYPE, ITEM_SUBCLASS, ITEM_COUNT, ITEM_AMOUNT, " +
      "SALES_COUNT, SALES_AMOUNT, CREDITS_COUNT, CREDITS_AMOUNT, RATE, PER_ITEM, FEES_DUE, DATA_SOURCE, DATA_SOURCE_ID, ME_LOAD_FILE_ID) " +
      "VALUES (mbs_daily_summary_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  private static final String QUERY_GET_LOAD_FILE_ID = "SELECT LOAD_FILE_ID FROM LOAD_FILE_INDEX WHERE LOAD_FILENAME = ?";
  private static final String QUERY_INSERT_MONTHLY_BILLING_PROCESS = "INSERT INTO MONTHLY_BILLING_PROCESS (REC_ID, PROCESS_TYPE, PROCESS_SEQUENCE, PROCESS_BEGIN_DATE " +
      ", PROCESS_ELAPSED, LOAD_FILENAME) VALUES (?, ?, ?, ?, ?, ?)";
  private static final String QUERY_UPDATE_MONTHLY_BILLING_PROCESS = "UPDATE MONTHLY_BILLING_PROCESS SET " +
      "PROCESS_SEQUENCE = ?, PROCESS_ELAPSED = ? WHERE REC_ID = ?";
  private static final String QUERY_GET_MONTHLY_BILLING_SUMMARY = "SELECT * FROM MONTHLY_BILLING_PROCESS WHERE ? = TO_CHAR(PROCESS_BEGIN_DATE, 'MMYY')";
  private static final String QUERY_GET_ACHPS_BILLING_JOB_DETAIL = "SELECT * FROM ACHPS_BILLING_JOB_DETAIL WHERE ? = TO_CHAR(PARAM_BEGIN_DATE, 'DDMMYY')";
  private static final String QUERY_GET_NEXT_DAILY_SUMMARY_SEQUENCE = "SELECT MBS_DAILY_SUMMARY_SEQ.NEXTVAL FROM DUAL";
  private static final String QUERY_CALL_FILE_INDEX_PROC = "CALL LOAD_FILE_INDEX_INIT(?)";
  
  private static final String ENTITY_ID = "ENTITY_ID";
  private static final String ITEM_TYPE = "ITEM_TYPE";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Transactional(rollbackFor=Exception.class)
  @Override
  public DailyJobStatusDto insertUpdateCreditDebitTransaction(List<CreditDebitTransaction> transactions, DailyJobStatusDto jobDto) {
	  int[][] rowCounts = null;
	  long successCounter = 0;
	  long failCounter = 0;
	  boolean batchException = false;
	  try {
		  rowCounts = jdbcTemplate.batchUpdate(QUERY_INSERT_CREDIT_DEBIT_RECORD, transactions, CREDIT_DEBIT_BATCH_SIZE, new ParameterizedPreparedStatementSetter<CreditDebitTransaction>() {
			  @Override
			  public void setValues(PreparedStatement ps, CreditDebitTransaction transaction)  throws SQLException {
				  ps.setString(1, transaction.getTransactionNumber());
				  ps.setString(2, transaction.getEntityId());
				  ps.setLong(3, transaction.getLocationId());
				  ps.setDate(4, new java.sql.Date(transaction.getEffectiveDate().getTime()));
				  ps.setDate(5, new java.sql.Date(transaction.getTransactionDate().getTime()));
				  ps.setString(6, transaction.getOperationType());
				  ps.setBigDecimal(7, transaction.getAmount());
				  ps.setString(8, transaction.getProfileId());
				  ps.setString(9, transaction.getReferenceNumber());
			  }
		  });
	  } catch (DuplicateKeyException e) {
		  batchException = true;
		  log.error("Batch Update exception occurred : " + e.getMessage());
		  jobDto = fallbackInsertUpdateCreditDebitTransaction(transactions, jobDto);
		  log.info("Executing fallback method, it will take longer time.");
	  } catch (Exception e) {
		  log.error("Error occurred while DB Execution: ", e);
	  }

	  if(!batchException) {
		  List<Integer> rowList = new ArrayList<>();
		  for(int[] batch : rowCounts) {
			  for(int element : batch) {
				  rowList.add(element);
			  }
		  }
		  if(transactions.size() != rowList.size()) {
			  jobDto.setJobStatus(DailyJobStatusDto.JobStatus.FAILED);
			  log.info("CreditDebitTransaction Database Insertion failed, database insertion count mismatch against actual data. Database insertions: "
					  + rowList.size() + ", Actual data: " + transactions.size());
		  } else {
			  for(int count = 0; count < transactions.size(); count++) {
				  if(rowList.get(count) == 0) {
					  failCounter++;
					  jobDto.setJobStatus(DailyJobStatusDto.JobStatus.FAILED);
					  log.error("CreditDebitTransaction Database Insertion failed for transaction element: " + transactions.get(count));
				  } else {
					  successCounter++;
					  log.info("CreditDebitTransaction Database Insertion successful for transaction element: " + transactions.get(count));
				  }
			  }
		  }
	  } else {
		  jobDto.setJobStatus(DailyJobStatusDto.JobStatus.FAILED);
	  }

	  log.info("Total Transaction Count: " + transactions.size() + ", Successful Transactions: " + successCounter + ", Failed Transactions: " + failCounter);
	  log.info("Batch completed.");

	  return jobDto;
  }

  /**
   * This method executes in the event of batch update failure due to inconsistent data
   * for credit debit transaction batch update, and ensures that all the valid data 
   * will get inserted in db, but  is much slower
   * 
   * @param transactions
   * @param jobDto
   * @return
   */
  private DailyJobStatusDto fallbackInsertUpdateCreditDebitTransaction(List<CreditDebitTransaction> transactions, DailyJobStatusDto jobDto) {
    int transCount = 0;
    for(CreditDebitTransaction transaction : transactions) {
      Integer rowCount = null;
      boolean duplicateKey = false;

      try {
        rowCount = jdbcTemplate.update(new PreparedStatementCreator() {
          @Override
          public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            PreparedStatement ps = con.prepareStatement(QUERY_INSERT_CREDIT_DEBIT_RECORD);
            ps.setString(1, transaction.getTransactionNumber());
            ps.setString(2, transaction.getEntityId());
            ps.setLong(3, transaction.getLocationId());
            ps.setDate(4, new java.sql.Date(transaction.getEffectiveDate().getTime()));
            ps.setDate(5, new java.sql.Date(transaction.getTransactionDate().getTime()));
            ps.setString(6, transaction.getOperationType());
            ps.setBigDecimal(7, transaction.getAmount());
            ps.setString(8, transaction.getProfileId());
            ps.setString(9, transaction.getReferenceNumber());
            return ps;
          }
        });

        if(rowCount == 0) {
          jobDto.setJobStatus(DailyJobStatusDto.JobStatus.FAILED);
        } else {
          transCount = transCount + rowCount;
        }
      } catch(DuplicateKeyException e) {
        duplicateKey =  true;
        log.error("Unable to insert duplicate transaction in fallback method: " + e.getMessage() + " -- "+ transaction.toString());
      } catch (Exception e) {
        log.error("Error occurred in fallback method for DB Execution for Transaction: " + e.getMessage() + " -- " + transaction.toString(), e);
        jobDto.setJobStatus(DailyJobStatusDto.JobStatus.FAILED);
      }

      if(!duplicateKey && transCount != transactions.size()) {
        jobDto.setJobStatus(DailyJobStatusDto.JobStatus.FAILED);
      }
    }

    return jobDto;
  }

  @Override
  public DailyJobStatusDto insertUpdateJobDescription(DailyJobStatusDto jobDto) {
    if(jobDto.getJobId() == null) {
      GeneratedKeyHolder holder = new GeneratedKeyHolder();
      int rowCount = jdbcTemplate.update(new PreparedStatementCreator() {
        @Override
        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
          PreparedStatement statement = con.prepareStatement(QUERY_INSERT_ACHPS_BILLING_JOB_DETAIL, new String[] {"JOB_ID"});
          statement.setString(1, jobDto.getJobType().name());
          statement.setDate(2, new java.sql.Date(jobDto.getParamBeginDate().getTime()));
          statement.setDate(3, new java.sql.Date(jobDto.getParamEndDate().getTime()));
          statement.setString(4, jobDto.getJobStatus().name());
          return statement;
        }
      }, holder);

      if(rowCount > 0) {
        Long jobId = holder.getKey().longValue();
        jobDto.setJobId(jobId);
        log.info("Job data inserted successfully.");
      } else {
        log.error("Unable to insert Job data.");
      }
    } else {
      int rowCount = jdbcTemplate.update(QUERY_UPDATE_ACHPS_BILLING_JOB_DETAIL, new Object[] {jobDto.getJobStatus().name(), jobDto.getJobId()});

      if(rowCount > 0) {
        log.info("Job data updated successfully.");
      } else {
        log.error("Unable to update Job data.");
      }
    }

    return jobDto;
  }

  @Override
  public List<Integer> getMerchants() {
    List<Integer> entities = null;
    List<Map<String, Object>> dbList = jdbcTemplate.queryForList(QUERY_GET_MERCHANTS);
    String strEntity =  null;

    if(dbList != null) {
      entities = new ArrayList<>();
      for(Map<String, Object> map : dbList) {
        try {
          strEntity = (String)map.get(ENTITY_ID);
          Integer entity = Integer.parseInt(strEntity);
          entities.add(entity);
        } catch (Exception e) {
          log.error("Invalid entity id: " + strEntity + " -->" + e.getMessage());
        }
      }
    }

    return entities;
  }

  @Override
  public Map<Integer, String> getAchElements() {
    Map<Integer, String> achElements = new HashMap<>();
    List<Map<String, Object>> dbList = jdbcTemplate.queryForList(QUERY_GET_ACH_MBS_ELEMENTS);
    try {
      if(dbList != null) {
        for(Map<String, Object> map : dbList) {
          achElements.put(((BigDecimal)map.get(ITEM_TYPE)).intValue(), (String)map.get("STATEMENT_MSG_DEFAULT"));
        }
      }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }

    return achElements;
  }

  @Override
  public Map<String, MerchantPricing> getMerchantProfile() {
    Map<String, MerchantPricing> merchProfiles = new HashMap<>();
    List<Map<String, Object>> pricings = jdbcTemplate.queryForList(QUERY_GET_MERCHANT_PROFILE);
    try {
        for(Map<String, Object> map : pricings) {
          MerchantPricing merchPricing = new MerchantPricing();
          merchPricing.setMerchNum(Long.parseLong((String)map.get("MERCH_NUM")));
          try {
            merchPricing.setEntityId(Integer.parseInt((String) map.get(ENTITY_ID)));
          } catch (Exception e) {
        	log.error(e.getMessage(), e);
          }

          try {
            merchPricing.setLocationId(Integer.parseInt((String)map.get("LOCATION_ID")));
          } catch (Exception e) {
        	log.error(e.getMessage(), e);
          }

          merchPricing.setItemDesc((String)map.get("ITEM_DESC"));
          merchPricing.setItemType(((BigDecimal)map.get(ITEM_TYPE)).longValue());
          BigDecimal perItem = BigDecimal.valueOf(0);

          try {
            perItem = (BigDecimal)map.get("PER_ITEM");
          } catch (Exception e) {
        	log.error(e.getMessage(), e);
          }

          merchPricing.setPerItem(perItem);

          BigDecimal rate = BigDecimal.valueOf(0);
          try {
            rate = (BigDecimal)map.get("RATE");
          } catch (Exception e) {
        	log.error(e.getMessage(), e);
          }

          merchPricing.setRate(rate);

          String key = merchPricing.getEntityId() + "#" + merchPricing.getLocationId() + "#" + merchPricing.getItemDesc();
          merchProfiles.put(key, merchPricing);
        }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
    return merchProfiles;
  }

  @Transactional
  @Override
  public void insertIntoMbsDailySummary(List<MbsDailySummary> summaries, String loadFilename) {
    log.info("Total number of record will be inserted into mbs_daily_summary: {}", summaries.size());

    jdbcTemplate.update(QUERY_CALL_FILE_INDEX_PROC, loadFilename);
    long loadFileId = jdbcTemplate.queryForObject(QUERY_GET_LOAD_FILE_ID, Long.class, loadFilename);

    jdbcTemplate.batchUpdate(QUERY_INSERT_MBS_DAILY_SUMMARY, summaries, MONTHLY_JDBC_BATCH_SIZE, new ParameterizedPreparedStatementSetter<MbsDailySummary>() {
      @Override
      public void setValues(PreparedStatement statement, MbsDailySummary summary) throws SQLException {
        statement.setLong(1, summary.getMerchantNumber());
        statement.setDate(2, new Date(DateTimeUtils.parseDate(summary.getActivityDate()).getTime()));
        statement.setInt(3, summary.getItemType());
        statement.setString(4, summary.getItemSubclass());
        statement.setInt(5, summary.getItemCount());
        statement.setBigDecimal(6, summary.getItemAmount());
        statement.setInt(7, summary.getSalesCount());
        statement.setBigDecimal(8, summary.getSalesAmount());
        statement.setInt(9, summary.getCreditCount());
        statement.setBigDecimal(10, summary.getCreditAmount());
        statement.setBigDecimal(11, summary.getRate());
        statement.setBigDecimal(12, summary.getPerItem());
        statement.setBigDecimal(13, summary.getFeeDue());
        statement.setString(14, loadFilename);
        statement.setLong(15, loadFileId);
        statement.setInt(16, 0);
      }
    });

    log.info("Database updated successfully");
  }

  @Override
  public long insertIntoJobTable(MonthlyBillingProcess billingProcess) {
    long recId = jdbcTemplate.queryForObject(QUERY_GET_NEXT_DAILY_SUMMARY_SEQUENCE, Long.class);

    jdbcTemplate.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement statement = con.prepareStatement(QUERY_INSERT_MONTHLY_BILLING_PROCESS);
        statement.setLong(1, recId);
        statement.setInt(2, billingProcess.getProcessType());
        statement.setInt(3, billingProcess.getProcessSequence());
        statement.setDate(4, new Date(billingProcess.getProcessBeginDate().getTime()));
        statement.setString(5, billingProcess.getProcessElapsed());
        statement.setString(6, billingProcess.getLoadFileName());

        return statement;
      }
    });
    return recId;
  }

  @Override
  public void updateJobTable(MonthlyBillingProcess billingProcess) {
    jdbcTemplate.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement statement = con.prepareStatement(QUERY_UPDATE_MONTHLY_BILLING_PROCESS);
        statement.setInt(1, billingProcess.getProcessSequence());
        statement.setString(2, billingProcess.getProcessElapsed());
        statement.setLong(3, billingProcess.getRecId());

        return statement;
      }
    });
  }
  
  @Override
  public boolean dailyJobLoaded(String dateMonthYear) {
    List<Map<String, Object>> records = jdbcTemplate.queryForList(QUERY_GET_ACHPS_BILLING_JOB_DETAIL, dateMonthYear);

    return records != null && !records.isEmpty() ? true : false;
  }

  @Override
  public boolean monthlySummaryLoaded(String monthYear) {
    List<Map<String, Object>> records = jdbcTemplate.queryForList(QUERY_GET_MONTHLY_BILLING_SUMMARY, monthYear);

    return records != null && !records.isEmpty() ? true : false;
  }
}
