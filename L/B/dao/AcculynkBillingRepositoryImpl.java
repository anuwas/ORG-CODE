package com.mes.lcr.billing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.mes.lcr.billing.dto.AcclynkSettlementDebitNetworkRowMapper;
import com.mes.lcr.billing.dto.AcculynkDtrHdrDataCount;
import com.mes.lcr.billing.dto.DailyDetailFileICDescRowMapper;
import com.mes.lcr.billing.dto.MerchantRawPricingRowMapper;
import com.mes.lcr.billing.dto.PinlessDebitNetworkFees;
import com.mes.lcr.billing.dto.PinlessDebitNetworkFeesRowMapper;
import com.mes.ps.billing.exception.BillingException;

@Component
public class AcculynkBillingRepositoryImpl implements AcculynkBillingRepository {

	static final Logger LOG = LoggerFactory.getLogger(AcculynkBillingRepositoryImpl.class);


	@SuppressWarnings("nls")
	private static final String SETTLEMENT_DETAIL_FROM_LOADFILENAME_QUERY = "SELECT DTR.ACQ_MID AS MERCHANT_NUMBER,SUM(DTR.ACCULYNK_SWITCH_FEE) AS SWITCHFEE,SUM(DTR.NETWORK_FEES) NETWORKFEE,SUM(DTR.INTERCHANGE_FEE) AS INTERCHANGE_FEE,0 AS DISCOUNTFEE,DTR.CARD_TYPE AS CARD_TYPE, TRUNC(DTR.TRANSACTION_DATETIME) AS TRANSACTION_DATETIME,   COUNT(*)  AS SALES_COUNT, SUM(NVL(DTR.TRANSACTION_AMT,0)) AS SALES_AMOUNT,0 AS CREDITS_COUNT, 0 AS CREDITS_AMOUNT,COUNT(*) AS ITEM_COUNT, SUM(NVL(DTR.TRANSACTION_AMT,0)) AS ITEM_AMOUNT,   DT.LOAD_FILENAME AS LOAD_FILENAME , DT.LOAD_FILE_ID AS LOAD_FILE_ID , DT.BATCH_DATE AS BATCH_DATE,decode(DTR.NETWORK,'PULS','PULS','STAR','STAR','XCEL','XCEL','NYCE','NYCE','OTHER') AS NETWORK ,DTR.REGULATED_INDICATOR AS REGULATED_INDICATOR   FROM MES.ACCULYNK_SETTLEMENT_FILE_HDR HDR   LEFT JOIN MES.ACCULYNK_SETTLEMENT_FILE_DTR DTR ON HDR.HDR_SEQ_NUM=DTR.HDR_SEQ_NUM   LEFT JOIN MES.DAILY_DETAIL_FILE_DT DT ON DTR.REF_KEY=DT.TRIDENT_TRAN_ID   AND TRUNC(DTR.TRANSACTION_DATETIME) = DT.TRANSACTION_DATE   WHERE HDR.LOADFILE_NAME = ? AND DT.LOAD_FILENAME IS NOT NULL AND DTR.NETWORK  IS NOT NULL AND DTR.REGULATED_INDICATOR IS NOT NULL   AND DTR.RESPONSE_CODE IN ('00') AND DT.CARD_TYPE IN ('VP','MP') GROUP BY DTR.ACQ_MID,DTR.CARD_TYPE,TRUNC(DTR.TRANSACTION_DATETIME),DT.LOAD_FILENAME,DT.LOAD_FILE_ID,DT.BATCH_DATE,decode(DTR.NETWORK,'PULS','PULS','STAR','STAR','XCEL','XCEL','NYCE','NYCE','OTHER') ,DTR.REGULATED_INDICATOR ";

	@SuppressWarnings("nls")
	private static final String SETTLEMENT_DETAIL_ZERO_DEBITNETWORK_QUERY = "SELECT DTR.DTR_SEQ_NUM AS DTR_SEQ_NUM,DTR.ACCULYNK_SWITCH_FEE AS SWITCHFEE,DTR.NETWORK_FEES AS NETWORKFEE,DTR.INTERCHANGE_FEE AS INTERCHANGE_FEE,DTR.CARD_TYPE AS CARD_TYPE, TRUNC(DTR.TRANSACTION_DATETIME) AS TRANSACTION_DATETIME,  DTR.TRANSACTION_AMT AS TRANSACTION_AMT,DTR.APPROVAL_AMT AS APPROVAL_AMT, DTR.NETWORK AS NETWORK  FROM MES.ACCULYNK_SETTLEMENT_FILE_DTR DTR  WHERE DTR.NETWORK_FEES = 0 AND DTR.LOADFILE_NAME = ? ";

	@SuppressWarnings("nls")
	private static final String MBS_DAILY_SUMMARY_INCOME_EXPENSE_INSERT_QUERY = "INSERT INTO MBS_DAILY_SUMMARY (REC_ID, MERCHANT_NUMBER, ACTIVITY_DATE, ITEM_TYPE, ITEM_SUBCLASS, IC_CAT, ITEM_COUNT, ITEM_AMOUNT,  SALES_COUNT, SALES_AMOUNT, CREDITS_COUNT, CREDITS_AMOUNT, RATE, PER_ITEM, FEES_DUE,FEES_PAID,EXPENSE, DATA_SOURCE, DATA_SOURCE_ID, ME_LOAD_FILE_ID,EXPENSE_ACTUAL)  VALUES (mbs_daily_summary_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

	@SuppressWarnings("nls")
	private static final String PREPARE_ACCK_FUNDING_DATA = "SELECT  T33.TRANSACTION_DATE,T33.AUTHORIZED_AMOUNT,T33.STND_IN_PROCESSING_ADVICE_CODE,T33.CURRENCY_CODE, T33.AUTHORIZED_AMOUNT, T33.VALIDATION_CODE, T33.RESPONSE_CODE , T33.AUTHORIZATION_CODE, T33.CARD_TYPE, T33.AUTH_INDICATOR , T33.MERCHANT_NUMBER , T33.PRODUCT_LEVEL_RESULT_CODE , T33.TRIDENT_TRANSACTION_ID , T33.REC_ID, T33.BANK_NUMBER, T33.TERMINAL_ID, T33.ACQUIRER_BIN,  MBS.BATCH_ID, MBS.MERCHANT_BATCH_DATE,MBS.LOAD_FILENAME,MBS.LOAD_FILE_ID, MI.DBA_NAME,MI.DDA_NUM,MI.TRANSIT_ROUTNG_NUM, TA.RETRIEVAL_REF_NUM, MBS.BATCH_NUMBER, TP.CATID  FROM MES.TC33_TRIDENT T33,MES.MBS_BATCHES MBS,MES.MIF MI,MES.TRIDENT_AUTH TA, MES.TRIDENT_PROFILE TP,MES.TRIDENT_CAPTURE_API TAPI    where MBS.BANK_NUMBER=T33.BANK_NUMBER and MBS.MERCHANT_NUMBER= T33.MERCHANT_NUMBER and MBS.TERMINAL_ID=T33.TERMINAL_ID   AND T33.MERCHANT_NUMBER=MI.MERCHANT_NUMBER  AND T33.TRIDENT_TRANSACTION_ID = TA.TRIDENT_TRANSACTION_ID   AND TP.TERMINAL_ID = MBS.TERMINAL_ID  AND TP.MERCHANT_NUMBER = MBS.MERCHANT_NUMBER  AND TAPI.CARD_TYPE IN ('VP','MP')  AND TAPI.TRIDENT_TRAN_ID = T33.TRIDENT_TRANSACTION_ID  AND TAPI.BATCH_NUMBER = MBS.BATCH_NUMBER  AND TAPI.BATCH_ID = MBS.BATCH_ID  AND T33.CARD_TYPE IN ('VP','MP') AND (T33.TRANSACTION_DATE) >= TRUNC(SYSDATE - 30)  AND T33.RESPONSE_CODE IN ('00')  AND T33.TRANSACTION_CODE NOT IN ('59')  AND NOT EXISTS ( 		SELECT 'x'  		FROM mes.TC33_TRIDENT tc33, MES.TRIDENT_AUTH TA1 		WHERE tc33.BANK_NUMBER = T33.BANK_NUMBER 			AND tc33.MERCHANT_NUMBER = T33.MERCHANT_NUMBER 			AND tc33.TERMINAL_ID = T33.TERMINAL_ID 			AND tc33.TRANSACTION_DATE = T33.TRANSACTION_DATE 			AND tc33.CARD_TYPE = t33.CARD_TYPE 			AND tc33.CARD_NUMBER = t33.CARD_NUMBER 			AND tc33.AUTHORIZED_AMOUNT = t33.AUTHORIZED_AMOUNT 			AND tc33.TRANSACTION_CODE = '59'		 			AND Tc33.TRIDENT_TRANSACTION_ID = TA1.TRIDENT_TRANSACTION_ID 			AND t33.RETRIEVAL_REFRENCE_NUMBER = TA1.RETRIEVAL_REF_NUM 		)  AND NOT EXISTS(SELECT 'X' FROM MES.DAILY_DETAIL_FILE_DT DT WHERE T33.TRIDENT_TRANSACTION_ID = DT.TRIDENT_TRAN_ID)  UNION ALL  SELECT  T33.TRANSACTION_DATE,T33.AUTHORIZED_AMOUNT,T33.STND_IN_PROCESSING_ADVICE_CODE,T33.CURRENCY_CODE, T33.AUTHORIZED_AMOUNT, T33.VALIDATION_CODE, T33.RESPONSE_CODE , T33.AUTHORIZATION_CODE, T33.CARD_TYPE, T33.AUTH_INDICATOR , T33.MERCHANT_NUMBER , T33.PRODUCT_LEVEL_RESULT_CODE , T33.TRIDENT_TRANSACTION_ID , T33.REC_ID, T33.BANK_NUMBER, T33.TERMINAL_ID, T33.ACQUIRER_BIN,  MBS.BATCH_ID, MBS.MERCHANT_BATCH_DATE,MBS.LOAD_FILENAME,MBS.LOAD_FILE_ID, MI.DBA_NAME,MI.DDA_NUM,MI.TRANSIT_ROUTNG_NUM, TA.RETRIEVAL_REF_NUM, MBS.BATCH_NUMBER, TP.CATID  FROM MES.TC33_TRIDENT T33,MES.MBS_BATCHES MBS,MES.MIF MI,MES.TRIDENT_AUTH TA, MES.TRIDENT_PROFILE TP,MES.TRIDENT_DETAIL_LOOKUP TDL    where MBS.BANK_NUMBER=T33.BANK_NUMBER and MBS.MERCHANT_NUMBER= T33.MERCHANT_NUMBER and MBS.TERMINAL_ID=T33.TERMINAL_ID   AND T33.MERCHANT_NUMBER=MI.MERCHANT_NUMBER  AND T33.TRIDENT_TRANSACTION_ID = TA.TRIDENT_TRANSACTION_ID   AND TP.TERMINAL_ID = MBS.TERMINAL_ID  AND TP.MERCHANT_NUMBER = MBS.MERCHANT_NUMBER  AND TDL.TRIDENT_TRANSACTION_ID = T33.TRIDENT_TRANSACTION_ID  AND TDL.AUTH_REC_ID = T33.REC_ID  AND TDL.BATCH_REC_ID = MBS.BATCH_ID  AND T33.CARD_TYPE IN ('VP','MP') AND (T33.TRANSACTION_DATE) >= TRUNC(SYSDATE - 30)  AND T33.RESPONSE_CODE IN ('00')  AND T33.TRANSACTION_CODE NOT IN ('59')  AND NOT EXISTS ( 		SELECT 'x'  		FROM mes.TC33_TRIDENT tc33, MES.TRIDENT_AUTH TA1 		WHERE tc33.BANK_NUMBER = T33.BANK_NUMBER 			AND tc33.MERCHANT_NUMBER = T33.MERCHANT_NUMBER 			AND tc33.TERMINAL_ID = T33.TERMINAL_ID 			AND tc33.TRANSACTION_DATE = T33.TRANSACTION_DATE 			AND tc33.CARD_TYPE = t33.CARD_TYPE 			AND tc33.CARD_NUMBER = t33.CARD_NUMBER 			AND tc33.AUTHORIZED_AMOUNT = t33.AUTHORIZED_AMOUNT 			AND tc33.TRANSACTION_CODE = '59'		 			AND Tc33.TRIDENT_TRANSACTION_ID = TA1.TRIDENT_TRANSACTION_ID 			AND t33.RETRIEVAL_REFRENCE_NUMBER = TA1.RETRIEVAL_REF_NUM 		)  AND NOT EXISTS(SELECT 'X' FROM MES.DAILY_DETAIL_FILE_DT DT WHERE T33.TRIDENT_TRANSACTION_ID = DT.TRIDENT_TRAN_ID)";

	@SuppressWarnings("nls")
	private static final String ACCK_FUNDING_DAILY_DETAIL_FILE_DT_INSERT_QUERY = "INSERT INTO MES.DAILY_DETAIL_FILE_DT   ( BATCH_NUMBER,DDF_DT_ID,ASSOCIATION_NUM,TRANSACTION_DATE,TRANSACTION_AMOUNT, AUTH_CURRENCY_CODE,AUTH_AMT,VALIDAT_CODE,AUTH_RESPON_CODE, MERCHANT_NAME,AUTHORIZATION_NUM,CARD_TYPE,CURRENCY_CODE,ORIGINAL_TRANSACTION_AMOUNT, FOREIGN_CARD_INDICATOR,MERCHANT_ACCOUNT_NUMBER,PRODUCT_ID,TRIDENT_TRAN_ID,AUTH_REC_ID, BANK_NUMBER,ORIGINAL_CURRENCY_CODE,IC_PAID,IC_EXPENSE,IC_EXPENSE_ENHANCED, DAILY_DISCOUNT_INTERCHANGE,BATCH_DATE,LOAD_FILENAME,REFERENCE_NUMBER, MERCHANT_BATCH_DATE, MERCHANT_BATCH_NUMBER, MERCHANT_ID, DEBIT_CREDIT_INDICATOR,ACH_FLAG,LOAD_FILE_ID,DISCOUNT_AMOUNT)   VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	@SuppressWarnings("nls")
	private static final String ACCK_FUNDING_ACH_DETAIL_INSERT_QUERY = "INSERT INTO MES.ACH_DETAIL   ( MERCHANT_NUMBER,RECORD_TYPE_CODE,TRANSACTION_CODE,RECEIVING_DFI_ID_TTTTAAAAC,DFI_ACCOUNT_NUMBER_DDA_NUMBER, AMOUNT_OF_TRANSACTION,INTERNAL_ACCOUNT_NUMBER,INDIVIDUAL_NAME,ADDENDA_RECORD_INDICATOR, FILE_CREATION_DATE,BATCH_NUMBER,POST_DATE_OPTION,BATCH_DETAIL_ID,BATCH_ID, FX_REFERENCE_NUMBER,FX_CB_ID,LOAD_FILENAME)   VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String PINLESS_DEBIT_NETWORKFEES_QUERY = "SELECT REC_ID , NETWORK, RATE , PER_ITEM FROM MES.PINLESS_DEBIT_NETWORK_FEES";

	private static final String PINLESS_DEBIT_NETWORKFEES_UPDATE_QUERY = "UPDATE MES.ACCULYNK_SETTLEMENT_FILE_DTR SET NETWORK_FEES = ? WHERE DTR_SEQ_NUM = ? ";

	@SuppressWarnings("nls")
	private static final String GET_SPECIF_PARTNER_MERCHANT_QUERY = "SELECT MF.MERCHANT_NUMBER AS  MERCHANT_NUMBER FROM MIF MF LEFT JOIN T_HIERARCHY TH ON MF.ASSOCIATION_NODE=TH.DESCENDENT WHERE TH.ANCESTOR  IN (?)";

	private static final String DAILY_DT_PROCESS_INSERT_QUERY = "INSERT INTO MES.DAILY_DETAIL_FILE_DT_PROCESS   (PROCESS_SEQUENCE,PROCESS_TYPE,LOAD_FILENAME,BATCH_DATE)   VALUES  (?,?,?,?)";

	private static final String QUERY_LOCK_FILENAME_POSTFIX = "LOCK TABLE FILENAME_POSTFIX IN EXCLUSIVE MODE ";

	private static final String QUERY_FETCH_FILETYPE_COUNT = "SELECT COUNT(1) FROM FILENAME_POSTFIX WHERE FILE_TYPE = ?";

	private static final String QUERY_INSERT_FILENAME_POSTFIX = "INSERT INTO FILENAME_POSTFIX (FILE_TYPE,LAST_DATE,LAST_COUNT) VALUES (?,?,?)";

	private static final String QUERY_SELECT_FILENAME_POSTFIX = "SELECT LAST_DATE,LAST_COUNT FROM FILENAME_POSTFIX WHERE FILE_TYPE = ?";

	private static final String QUERY_UPDATE_FILENAME_POSTFIX = "UPDATE FILENAME_POSTFIX SET LAST_DATE = ?,LAST_COUNT = ? WHERE FILE_TYPE = ?";

	private static final String DELETE_MBS_DAILY_SUMMARY_DATA_BY_LOADFILE_DATE = "DELETE FROM MBS_DAILY_SUMMARY WHERE ACTIVITY_DATE IN (SELECT  DT.BATCH_DATE AS BATCH_DATE  FROM MES.ACCULYNK_SETTLEMENT_FILE_HDR HDR   LEFT JOIN MES.ACCULYNK_SETTLEMENT_FILE_DTR DTR ON HDR.HDR_SEQ_NUM=DTR.HDR_SEQ_NUM   LEFT JOIN MES.DAILY_DETAIL_FILE_DT DT ON DTR.REF_KEY=DT.TRIDENT_TRAN_ID    AND TRUNC(DTR.TRANSACTION_DATETIME) = DT.TRANSACTION_DATE    WHERE HDR.LOADFILE_DATE = TO_DATE( ? ,'DD/MM/YY') AND DT.LOAD_FILENAME IS NOT NULL    AND  DT.CARD_TYPE IN ('VP','MP') GROUP BY DT.BATCH_DATE) AND ITEM_SUBCLASS IN ('VP','MP')";

	private static final String QUERY_DELETE_FILENAME_FROM_LOADFILE_INDEX = "DELETE FROM LOAD_FILE_INDEX WHERE LOAD_FILENAME IN (:loadfileNames)";

	private static final String QUERY_GET_LOAD_FILE_LIST_TO_RUN_BILLING = "SELECT LOADFILE_NAME FROM MES.ACCULYNK_SETTLEMENT_FILE_HDR HDR WHERE HDR.LOADFILE_DATE = TO_DATE(?,'DD/MM/YY') AND   HDR.BILLING_JOB_STATUS IS NULL OR  HDR.BILLING_JOB_STATUS = 'FAILED' FOR UPDATE NOWAIT ";

	private static final String QUERY_GET_LOAD_FILE_LIST_TO_CLEAR_BILLING = "SELECT LOADFILE_NAME FROM MES.ACCULYNK_SETTLEMENT_FILE_HDR WHERE   MES.ACCULYNK_SETTLEMENT_FILE_HDR.LOADFILE_DATE = TO_DATE(?,'DD/MM/YY')";

	private static final String DAILY_BILLING_JOB_STATUS_UPDATE_QUERY = "UPDATE ACCULYNK_SETTLEMENT_FILE_HDR SET BILLING_JOB_STATUS = ? WHERE LOADFILE_NAME = ? ";

	private static final String MERCHANT_RAW_PRICING_QUERY = "SELECT DTR.ACQ_MID AS MERCHANT_NUMBER,MP.ITEM_SUBCLASS,NVL(MP.RATE,0) AS RATE,NVL(MP.PER_ITEM,0) AS  PER_ITEM,MP.ITEM_TYPE from MES.ACCULYNK_SETTLEMENT_FILE_DTR DTR JOIN MBS_PRICING MP   ON DTR.ACQ_MID=MP.MERCHANT_NUMBER WHERE DTR.LOADFILE_NAME = ? AND MP.ITEM_SUBCLASS in ('VP','MP') and MP.VALID_DATE_END >= CURRENT_DATE   GROUP BY DTR.ACQ_MID,MP.ITEM_SUBCLASS,MP.RATE,MP.PER_ITEM,MP.ITEM_TYPE";

	private static final String DAILY_DETAIL_FILE_IC_DESC_SELECT_QUERY = "SELECT REC_ID,CARD_TYPE,IC_CODE,IC_DESC,IC_RATE,IC_PER_ITEM,VALID_DATE_BEGIN,VALID_DATE_END,REG_IC_CODE,BASE_RATE,BASE_PER_ITEM   FROM DAILY_DETAIL_FILE_IC_DESC DDFIC WHERE CARD_TYPE IN ('VP','MP') AND VALID_DATE_END >= CURRENT_DATE";

	private static final String ACCULYNK_SETTLEMENT_HDR_DTR_COMPARE = "SELECT  ( SELECT HDR.NUM_OF_RECORDS FROM   MES.ACCULYNK_SETTLEMENT_FILE_HDR HDR where HDR.LOADFILE_NAME= ? ) AS HDR_COUNT,   ( SELECT COUNT(*) FROM   MES.ACCULYNK_SETTLEMENT_FILE_DTR DTR LEFT JOIN MES.ACCULYNK_SETTLEMENT_FILE_HDR HDR ON HDR.HDR_SEQ_NUM=DTR.HDR_SEQ_NUM   WHERE HDR.LOADFILE_NAME = ? ) AS DTR_COUNT FROM  dual";

	@SuppressWarnings("nls")
	private static final String MERCHANT_SCHEMA = "MES";
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@SuppressWarnings("nls")
	@Override
	@Transactional
	public Long callLoadFileIndex(String loadFilename) {
		Long fileId = 0L;
		try {
			this.jdbcTemplate.update("call load_file_index_init(?)", loadFilename);
			fileId = this.jdbcTemplate.queryForObject("SELECT load_file_id FROM load_file_index WHERE load_filename = ?", Long.class, loadFilename);
		}
		catch (Exception ex) {
			LOG.error("Failed to fetch load_file_id from load_file_index for LCR Billing Service , Exception ", ex);
		}
		return fileId;
	}

	@SuppressWarnings({"nls", "boxing"})
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertIncomeExpenseIntoMbsDailySummary(List<MBSDailySummaryIncomeExpense> mbsDailySummaryIncomeExpenselist) {
		this.jdbcTemplate.batchUpdate(MBS_DAILY_SUMMARY_INCOME_EXPENSE_INSERT_QUERY, new BatchPreparedStatementSetter() {

			@SuppressWarnings("nls")
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				try {
					ps.setLong(1, mbsDailySummaryIncomeExpenselist.get(i).getMerchantNumber());
					ps.setDate(2, new java.sql.Date(mbsDailySummaryIncomeExpenselist.get(i).getActivityDate().getTime()));
					ps.setInt(3, mbsDailySummaryIncomeExpenselist.get(i).getItemType());
					ps.setString(4, mbsDailySummaryIncomeExpenselist.get(i).getItemSubclass());
					ps.setString(5, mbsDailySummaryIncomeExpenselist.get(i).getIcCat());
					ps.setInt(6, mbsDailySummaryIncomeExpenselist.get(i).getItemCount());
					ps.setDouble(7, mbsDailySummaryIncomeExpenselist.get(i).getItemAmount());
					ps.setInt(8, mbsDailySummaryIncomeExpenselist.get(i).getSalesCount());
					ps.setDouble(9, mbsDailySummaryIncomeExpenselist.get(i).getSalesAmount());
					ps.setInt(10, mbsDailySummaryIncomeExpenselist.get(i).getCreditCount());
					ps.setDouble(11, mbsDailySummaryIncomeExpenselist.get(i).getCreditAmount());
					ps.setDouble(12, mbsDailySummaryIncomeExpenselist.get(i).getRate());
					ps.setDouble(13, mbsDailySummaryIncomeExpenselist.get(i).getPerItem());
					ps.setDouble(14, mbsDailySummaryIncomeExpenselist.get(i).getFeesDue());
					ps.setDouble(15, mbsDailySummaryIncomeExpenselist.get(i).getFeesPaid());
					ps.setDouble(16, mbsDailySummaryIncomeExpenselist.get(i).getExpense());
					ps.setString(17, mbsDailySummaryIncomeExpenselist.get(i).getDataSourceName());
					ps.setLong(18, mbsDailySummaryIncomeExpenselist.get(i).getDataSourceId());
					ps.setInt(19, 0);
					ps.setDouble(20, mbsDailySummaryIncomeExpenselist.get(i).getExpenseActual());

				}
				catch (SQLException e) {
					LOG.error(" Daily Process Status failed. Error while inserting data into MBS_DAILY_SUMMARY : ", e);
					throw new BillingException("Failed in AcculynkBillingRepositoryImpl.insertIncomeExpenseIntoMbsDailySummary : ", e);

				}
			}

			@Override
			public int getBatchSize() {
				return mbsDailySummaryIncomeExpenselist.size();
			}
		});
	}


	@Override
	public List<AcclynkSettlementFileDTR> getSettlementDataFromLoadfileName(String loadfileDate) {
		try {
			return this.jdbcTemplate.query(String.format(SETTLEMENT_DETAIL_FROM_LOADFILENAME_QUERY, MERCHANT_SCHEMA), new Object[] {
					loadfileDate}, new AcclynkSettlementFileDTRRowMapper());
		}
		catch (Exception ex) {
			LOG.error("Selecting from Settlement Detail Table for load_filename failed for LCR Billing Service : ", ex);
			return new ArrayList<>();
		}
	}

	@Override
	public List<AcclynkSettlementFileDTR> getAcculynkSettlementDTRZeroDebitNetwork(String loadfileDate) {
		try {
			return this.jdbcTemplate.query(String.format(SETTLEMENT_DETAIL_ZERO_DEBITNETWORK_QUERY, MERCHANT_SCHEMA), new Object[] {
					loadfileDate}, new AcclynkSettlementDebitNetworkRowMapper());
		}
		catch (Exception ex) {
			LOG.error("Selecting from Settlement Detail Table for zero Debit Network failed for LCR Billing Service : ", ex);
			return new ArrayList<>();
		}
	}


	@Override
	public List<DailyDetailFileDTF> getDailyDetailFundingList() {
		try {
			return this.jdbcTemplate.query(String.format(PREPARE_ACCK_FUNDING_DATA, MERCHANT_SCHEMA), new DailyDetailFileDtRowMapper());
		}
		catch (Exception ex) {
			LOG.error("Selecting from DAILY_DETAIL_FILE_DT for LCR Funding failed for LCR Billing service ,Exception {} ", ex);
			return new ArrayList<>();
		}
	}

	@Override
	public void acckFundingDailyDetailDtInsertProcess(List<DailyDetailFileDTF> dailyDetailFileDTs) {

		this.jdbcTemplate.batchUpdate(ACCK_FUNDING_DAILY_DETAIL_FILE_DT_INSERT_QUERY, new BatchPreparedStatementSetter() {

			@SuppressWarnings("nls")
			@Override
			public void setValues(PreparedStatement ps, int i) {
				try {
					DailyDetailFileDTF dailyDetailFileDT = dailyDetailFileDTs.get(i);
					ps.setString(1, dailyDetailFileDT.getBatchNumber());
					ps.setLong(2, dailyDetailFileDT.getDdfDtId());

					ps.setLong(3, dailyDetailFileDT.getAssociationNum());
					ps.setDate(4, dailyDetailFileDT.getTransactionDate());
					ps.setDouble(5, dailyDetailFileDT.getTransactionAmount());
					ps.setLong(6, dailyDetailFileDT.getAuthCurrencyCode());
					ps.setDouble(7, dailyDetailFileDT.getAuthAmt());
					ps.setString(8, dailyDetailFileDT.getValidatCcode());
					ps.setString(9, dailyDetailFileDT.getAuthRresponCode());
					ps.setString(10, dailyDetailFileDT.getMerchantName());
					ps.setString(11, dailyDetailFileDT.getAuthorizationNum());
					ps.setString(12, dailyDetailFileDT.getCardType());
					ps.setString(13, dailyDetailFileDT.getCurrencyCode());
					ps.setDouble(14, dailyDetailFileDT.getOriginalTransactionAmount());
					ps.setString(15, dailyDetailFileDT.getForeignCardIndicator());
					ps.setLong(16, dailyDetailFileDT.getMerchantAccountNumber());
					ps.setString(17, dailyDetailFileDT.getProductId());
					ps.setString(18, dailyDetailFileDT.getTridentTranId());
					ps.setLong(19, dailyDetailFileDT.getAuthRecId());
					ps.setLong(20, dailyDetailFileDT.getBankNumber());
					ps.setString(21, dailyDetailFileDT.getOriginalCurrencyCode());

					ps.setDouble(22, dailyDetailFileDT.getIcPaid());
					ps.setDouble(23, dailyDetailFileDT.getIcExpense());
					ps.setDouble(24, dailyDetailFileDT.getIcExpenseEnhanced());
					ps.setString(25, dailyDetailFileDT.getDailyDiscountInterchange());
					ps.setDate(26, dailyDetailFileDT.getBatchDate());
					ps.setString(27, dailyDetailFileDT.getLoadFilename());
					ps.setString(28, dailyDetailFileDT.getReferenceNumber());
					ps.setDate(29, dailyDetailFileDT.getBatchDate());
					ps.setLong(30, dailyDetailFileDT.getMerchantBatchNumber());
					ps.setString(31, dailyDetailFileDT.getMerchantId());
					ps.setString(32, dailyDetailFileDT.getDebitCreditIndicator());
					ps.setString(33, dailyDetailFileDT.getAchFlag());
					ps.setLong(34, dailyDetailFileDT.getLoadFileId());
					ps.setDouble(35, dailyDetailFileDT.getDiscountAmount());
				}
				catch (SQLException e) {
					LOG.error("Acculynk Funding Process failed. Error in inserting data into DAILY_DETAIL_FILE_DT table : ", e);
					throw new BillingException("Failed in AcculynkBillingRepositoryImpl.acckFundingDailyDetailDtInsertProcess : ", e);
				}

			}

			@Override
			public int getBatchSize() {
				return dailyDetailFileDTs.size();
			}
		});

	}


	@SuppressWarnings("nls")
	@Override
	public void loadACHSummary(String loadFileName) {
		try {
			if (!StringUtils.isEmpty(loadFileName)) {
				int i = this.jdbcTemplate.update("call load_ach_summary(?)", loadFileName);
				if (i > 0) {
					LOG.info("Successfully load ach summary for file - {}", loadFileName);
				}
			}
		}
		catch (DataAccessException e) {
			LOG.error("Load Ach Summary failed : ", e);
			throw new BillingException("Failed in AcculynkBillingRepositoryImpl.loadACHSummary : ", e);
		}
	}

	@Override
	public void acckFundingAchDetailInsertProcess(List<AchDetails> achDetails) {
		this.jdbcTemplate.batchUpdate(ACCK_FUNDING_ACH_DETAIL_INSERT_QUERY, new BatchPreparedStatementSetter() {

			@SuppressWarnings("nls")
			@Override
			public void setValues(PreparedStatement ps, int i) {
				try {

					AchDetails achDetail = achDetails.get(i);

					ps.setLong(1, achDetail.getMerchantNumber());
					ps.setString(2, achDetail.getRecordTypeCode());
					ps.setLong(3, achDetail.getTransactionCode());
					ps.setString(4, achDetail.getReceivingDfiIdTtttaaaac());
					ps.setString(5, achDetail.getDfiAccountNumberDdaNumber());

					ps.setDouble(6, achDetail.getAmountOfTransaction());
					ps.setString(7, achDetail.getInternalAccountNumber());
					ps.setString(8, achDetail.getIndividualName());
					ps.setString(9, achDetail.getAddendaRecordIndicator());

					ps.setDate(10, achDetail.getFileCreationDate());
					ps.setLong(11, achDetail.getBatchNumber());
					ps.setDate(12, achDetail.getPostDateOption());
					ps.setLong(13, achDetail.getBatchDetailId());
					ps.setLong(14, achDetail.getBatchId());

					ps.setString(15, achDetail.getFxReferenceNumber());
					ps.setLong(16, achDetail.getFxCbId());
					ps.setString(17, achDetail.getLoadFilename());

				}
				catch (SQLException e) {
					LOG.error("Acculynk Funding Process Status failed. Error in inserting data into ACH_DETAIL table : ", e);
					throw new BillingException("Failed in AcculynkBillingRepositoryImpl.acckFundingAchDetailInsertProcess : ", e);
				}

			}

			@Override
			public int getBatchSize() {
				return achDetails.size();
			}
		});
	}


	@Override
	public List<PinlessDebitNetworkFees> getPinlessDebitNetWrorkFees() {
		try {
			return this.jdbcTemplate.query(String.format(PINLESS_DEBIT_NETWORKFEES_QUERY, MERCHANT_SCHEMA), new PinlessDebitNetworkFeesRowMapper());
		}
		catch (Exception ex) {
			LOG.error("Fetching Pinless Debit Network Fees failed for LCR Billing service ,Exception {} ", ex);
			return new ArrayList<>();
		}
	}

	@Override
	@Transactional
	public void updateSettlementDTRZeroDebitNetwork(final List<AcclynkSettlementFileDTR> acclynkSettlementFileDTRList) {
		jdbcTemplate.batchUpdate(PINLESS_DEBIT_NETWORKFEES_UPDATE_QUERY, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setDouble(1, acclynkSettlementFileDTRList.get(i).getNetworkfee());
				ps.setLong(2, acclynkSettlementFileDTRList.get(i).getDtrSeqNum());

			}

			@Override
			public int getBatchSize() {
				return acclynkSettlementFileDTRList.size();
			}
		});
	}


	@Override
	public void insertIntoDtProcess(long processSequence, int processType, String loadFileName, java.sql.Date batchDate) {
		try {
			int rowCount = this.jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement statement = con.prepareStatement(DAILY_DT_PROCESS_INSERT_QUERY);
					statement.setLong(1, processSequence);
					statement.setInt(2, processType);
					statement.setString(3, loadFileName);
					statement.setDate(4, batchDate);
					return statement;
				}
			});

			LOG.info("Funding job update {} records in DAILY_DETAIL_FILE_DT_PROCESS table", rowCount);
		}
		catch (Exception ex) {
			LOG.error("Inserting into DAILY_DETAIL_FILE_DT_PROCESS failed for LCR Billing Service ,Exception {} ", ex);
		}

	}

	@Override
	public Integer generateFileIdSequence(String fileType, String dateString) {
		Integer fileId = 0;
		try {
			this.jdbcTemplate.execute(QUERY_LOCK_FILENAME_POSTFIX);
			if (StringUtils.isBlank(fileType)) {
				return fileId;
			}

			int recCount = this.jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class);
			if (recCount == 0) {
				fileId = 1;
				this.jdbcTemplate.update(QUERY_INSERT_FILENAME_POSTFIX, fileType, dateString, fileId);
			}
			else {
				FileNamePostFix fileNamePostFix = this.jdbcTemplate.queryForObject(QUERY_SELECT_FILENAME_POSTFIX, new Object[] {
						fileType}, new FileNamePostFixMapper());
				if (fileNamePostFix != null) {
					if (fileNamePostFix.getDateString() != null && fileNamePostFix.getDateString().equals(dateString)) {
						fileId = fileNamePostFix.getFileId() + 1;
					}
					else {
						fileId = 1;
					}
				}
				else {
					fileId = 212;
				}
				this.jdbcTemplate.update(QUERY_UPDATE_FILENAME_POSTFIX, dateString, fileId, fileType);
			}
		}
		catch (Exception ex) {
			LOG.error("Generating File Id Sequence for LCR Billing Service failed,Exception {} ", ex);
		}
		return fileId;
	}

	@Override
	@Transactional
	public List<String> getListofSettlementFilesnotBilled(String loadfileDate) {
		List<String> loadfileNames = new ArrayList<>();
		try {
			ResultSetExtractor<?> rch = new ResultSetExtractor<Object>() {
				@Override
				public Object extractData(ResultSet rs) throws SQLException {
					while (rs.next()) {
						final String filename = rs.getString(1);
						LOG.info("FOR UPDATE IN LOCK LOAD FILENAME {}", filename);
						boolean fileDataCount = jdbcTemplate.query(ACCULYNK_SETTLEMENT_HDR_DTR_COMPARE, new Object[] {filename,
								filename}, new AcculynkDtrHdrDataCount());
						if (fileDataCount) {
							loadfileNames.add(filename);
							jdbcTemplate.update(DAILY_BILLING_JOB_STATUS_UPDATE_QUERY, "PROCESSING", filename);
						}
						else {
							LOG.info("This file ({}) still in file loading process ", filename);
						}
					}
					return null;
				}
			};
			Object[] args = {loadfileDate};
			this.jdbcTemplate.query(QUERY_GET_LOAD_FILE_LIST_TO_RUN_BILLING, args, rch);
		}
		catch (Exception ex) {
			LOG.error("ERROR IN SELECTING LOADFILENAME FROM DTR WITH ROW LOCK AND RENAME FILENAME, Exception", ex);
		}
		return loadfileNames;
	}

	@Override
	public List<String> getListofSettlementFilesToClear(String loadfileDate) {
		LOG.info("Getting loadfile names which are not yet loaded for daily billing, Date {}", loadfileDate);
		try {
			List<String> loadfileNames = this.jdbcTemplate.queryForList(String.format(QUERY_GET_LOAD_FILE_LIST_TO_CLEAR_BILLING, MERCHANT_SCHEMA), new Object[] {
					loadfileDate}, String.class);
			LOG.info("Filenames list  {} ", loadfileNames);
			return loadfileNames;
		}
		catch (Exception ex) {
			LOG.error("Query Execute Exception , Query {} ", QUERY_GET_LOAD_FILE_LIST_TO_CLEAR_BILLING);
			return new ArrayList<>();
		}
	}

	@Override
	@Transactional
	public boolean cleanAcculynkDailyBillingDataByLoadfileDate(String loadfileDate, List<String> loadfileNames) {
		this.jdbcTemplate.update(DELETE_MBS_DAILY_SUMMARY_DATA_BY_LOADFILE_DATE, loadfileDate);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
		MapSqlParameterSource parameters = new MapSqlParameterSource();

		if (loadfileNames != null && !loadfileNames.isEmpty()) {
			parameters.addValue("loadfileNames", loadfileNames);
			namedParameterJdbcTemplate.update(QUERY_DELETE_FILENAME_FROM_LOADFILE_INDEX, parameters);
		}

		return true;
	}

	@Override
	@Transactional
	public void updateBillingJobStatusForaFile(String jobStatus, String loadfileName) {
		try {
			this.jdbcTemplate.update(String.format(DAILY_BILLING_JOB_STATUS_UPDATE_QUERY, MERCHANT_SCHEMA), jobStatus, loadfileName);
			LOG.info("JOB STATUS UPDATED FOR DAILY BILLING JOB, FILENAME {} , JOBSTATUS {} ", loadfileName, jobStatus);
		}
		catch (Exception ex) {
			LOG.error("Failed to update daily billing job status , Exception ", ex);
		}
	}

	@Override
	public Map<String, MbsPricing> getMerchantRawPricingFromLoadfile(String loadfileName) {
		try {
			LOG.debug("Executing query to get merchant pricing  ");
			return this.jdbcTemplate.query(MERCHANT_RAW_PRICING_QUERY, new Object[] {loadfileName}, new MerchantRawPricingRowMapper());
		}
		catch (Exception ex) {
			LOG.error("Exception in execute query to get merchant pricing, Exception ", ex);
			return new HashMap<>();
		}
	}

	@Override
	public Map<String, DailyDetailFileICDesc> getDailyDetailFileICDescVpMp() {
		try {
			final DailyDetailFileICDescRowMapper rowMapper = new DailyDetailFileICDescRowMapper();
			LOG.debug("Executing query to get pricing from DAILY_DETAIL_FILE_IC_DESC ");
			return this.jdbcTemplate.query(String.format(DAILY_DETAIL_FILE_IC_DESC_SELECT_QUERY, MERCHANT_SCHEMA), new Object[] {}, rowMapper);
		}
		catch (Exception ex) {
			LOG.error("Exception in execute query to get merchant pricing from DAILY_DETAIL_FILE_IC_DESC, Exception {} ", ex);
			return new HashMap<>();
		}
	}

	@Override
	public List<Long> getParnterMerchants(long groupId) {
		LOG.debug("Executing parnter merchant with the groupid {}  ", groupId);
		try {
			LOG.debug("Callling Billing Tree Merchant , Query {} ", GET_SPECIF_PARTNER_MERCHANT_QUERY);
			List<Long> partnerMerchantList = jdbcTemplate.queryForList(GET_SPECIF_PARTNER_MERCHANT_QUERY, new Object[] {groupId}, Long.class);
			LOG.info("Getting Billing Tree MerchantList, GroupID {},  DataCount {}", groupId, partnerMerchantList.size());
			return partnerMerchantList;
		}
		catch (Exception ex) {
			LOG.error("Exception in execute query to get merchant Billing Tree Merchant , Query {}, Exception {} ", GET_SPECIF_PARTNER_MERCHANT_QUERY, ex.getMessage());
			return new ArrayList<>();
		}
	}
}
