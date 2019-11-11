package com.mes.ps.billing.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.mes.ps.billing.config.BankNumberConfig;
import com.mes.ps.billing.dao.BillingRepository;
import com.mes.ps.billing.dto.CreditDebitDetailsTo;
import com.mes.ps.billing.dto.CreditDebitResponse;
import com.mes.ps.billing.dto.CreditDebitTo;
import com.mes.ps.billing.dto.DailyJobStatusDto;
import com.mes.ps.billing.dto.DailySummary;
import com.mes.ps.billing.dto.EventReport;
import com.mes.ps.billing.dto.MerchantPricing;
import com.mes.ps.billing.dto.MerchantProfile;
import com.mes.ps.billing.dto.MonthlyBillingProcess;
import com.mes.ps.billing.dto.MonthlyBillingSummaryTo;
import com.mes.ps.billing.dto.DailyJobStatusDto.JobStatus;
import com.mes.ps.billing.entity.CreditDebitTransaction;
import com.mes.ps.billing.entity.MbsDailySummary;
import com.mes.ps.billing.exception.BillingException;
import com.mes.ps.billing.exception.ErrorCode;
import com.mes.ps.billing.transaction.adapter.ProfitStarsAdapter;
import com.mes.ps.billing.util.DateTimeUtils;

/**
 * Service layer implementation for billing application
 */
@Component
@EnableConfigurationProperties
public class ProfitStarsServiceImpl implements ProfitStarsService {
	private static final Logger LOG = LoggerFactory.getLogger(ProfitStarsServiceImpl.class);
	@Value("${ps.api.storeId}")
	private String storeId;
	@Value("${ps.api.storeKey}")
	private String storeKey;
	@Autowired
	private BankNumberConfig config;
	@Autowired
	private ProfitStarsAdapter profitStarsAdapter;
	@Autowired
	private BillingRepository reportRepository;


	@Override
	public List<MbsDailySummary> processMonthlyBillingSummary(Date billingMonth) {
		//Fetch merchants profiles
		Map<String, MerchantPricing> merchantPricing = reportRepository.getMerchantProfile();
		Map<Integer, String> achElements = reportRepository.getAchElements();
		Map<String, MerchantProfile> merchantProfiles = new HashMap<>();
		List<MbsDailySummary> mbsDailySummaries = new ArrayList<>();
		String beginDate = DateTimeUtils.getDateString(DateTimeUtils.getDate(billingMonth, -1, -1));
		String endDate = DateTimeUtils.getDateString(DateTimeUtils.getDate(billingMonth, 1, -1));

		for(Map.Entry<String, MerchantPricing> profileEntry : merchantPricing.entrySet()) {
			MerchantPricing pricing = profileEntry.getValue();

			MerchantProfile profile = new MerchantProfile();
			String profileKey = pricing.getEntityId() + "-" + pricing.getLocationId();
			profile.setEntityId(pricing.getEntityId());
			profile.setLocationId(pricing.getLocationId());
			profile.setMerchantNumber(pricing.getMerchNum());
			merchantProfiles.put(profileKey, profile);
		}

		LOG.info("Total No. of Merchant profile to be processed: {}", merchantProfiles.size());
		for(Map.Entry<String, MerchantProfile> profileEntry : merchantProfiles.entrySet()) {
			MerchantProfile profile = profileEntry.getValue();
			MonthlyBillingSummaryTo billingSummaryTo = new MonthlyBillingSummaryTo();
			billingSummaryTo.setEntityId(profile.getEntityId());
			billingSummaryTo.setStoreId(Long.parseLong(storeId));
			billingSummaryTo.setStoreKey(storeKey);
			billingSummaryTo.setBeginDate(beginDate);
			billingSummaryTo.setEndDate(endDate);
			billingSummaryTo.setLocationId(profile.getLocationId());

			try {
				// set values for table column
				processProfileRecords(profile, billingSummaryTo, mbsDailySummaries, merchantPricing, achElements);
			} catch (Exception e) {
				LOG.error("Uanble to fetch Billing Data form PS API for entityId:{}, locationId:{}",
						"xxxx", "xxxx");
			}
		}

		return mbsDailySummaries;
	}

	@Override
	public List<MonthlyBillingProcess> acquireDatabaseLock(Date date) {
		LOG.info("passing date ", date);
		String monthYear = new SimpleDateFormat("MMyy").format(date);
		boolean loaded = reportRepository.monthlySummaryLoaded(monthYear);

		if (loaded) {
			throw new BillingException(new ErrorCode(""));
		}

		List<MonthlyBillingProcess> processes = new ArrayList<>();
		//loop through all the banks
		config.getNumbers().forEach((bankNumber)->{
			MonthlyBillingProcess billingProcess = new MonthlyBillingProcess();
			billingProcess.setProcessBeginDate(date);
			String firstDayOfMonth = new SimpleDateFormat("MMddyy").format(DateTimeUtils.getDate(date, -1, -1));
			String loadFilename = "achps" + bankNumber.intValue() + "_" + firstDayOfMonth + "_001.dat";

			billingProcess.setProcessType(1);
			billingProcess.setProcessSequence(-1);
			billingProcess.setLoadFileName(loadFilename);
			LOG.info("Acquiring lock for file: {}", loadFilename);
			//update JOB table
			long recId = reportRepository.insertIntoJobTable(billingProcess);
			billingProcess.setRecId(recId);
			billingProcess.setProcessBeginDate(new Date());
			processes.add(billingProcess);
		});

		return processes;
	}

	public void releaseDatabaseLock(List<MonthlyBillingProcess> processes) {
		processes.forEach((element)->{
			release(element);
		});
	}

	private void release(MonthlyBillingProcess billingProcess) {
		LOG.info("Releasing lock for file: {}", billingProcess.getLoadFileName());
		billingProcess.setProcessEndDate(new Date());
		long elapsedTime = (billingProcess.getProcessEndDate().getTime() - billingProcess.getProcessBeginDate().getTime())/1000;
		billingProcess.setProcessElapsed(String.valueOf(elapsedTime));
		reportRepository.updateJobTable(billingProcess);
	}

	@Override
	public void updateMonthlyBillingSummary(List<MbsDailySummary> mbsDailySummaries, MonthlyBillingProcess process) {
		//update MBS_DAILY_SUMMARY table
		reportRepository.insertIntoMbsDailySummary(mbsDailySummaries, process.getLoadFileName());
	}

	@Override
	public void isDailyJobLoaded(Date jobExecutionDate) {
		//To validate daily job executed for that day
		Date jobStartDate = DateTimeUtils.getDailyJobDate(jobExecutionDate);
		String dayMonthYear = new SimpleDateFormat(DateTimeUtils.FORMAT_ddMMyy).format(jobStartDate);
		boolean loaded = reportRepository.dailyJobLoaded(dayMonthYear);
		if (loaded) {
			throw new BillingException(new ErrorCode(""));
		}
	}

	@Override
	public String updateDailyTransactionDetailJob(Date jobExecutionDate) {
		LOG.info("updateDailyTransactionDeatilJob executing");

		//Get Job start date which is the previous day of the job execution date
		String jobStartDate = DateTimeUtils.getDailyJobDateAsString(jobExecutionDate);

		//Insert data into the ACHPS_BILLING_JOB_DETAIL for job status
		XMLGregorianCalendar[] dates = DateTimeUtils.parseDate(jobStartDate, jobStartDate);
		DailyJobStatusDto jobDto = new DailyJobStatusDto();
		jobDto.setJobType(DailyJobStatusDto.JobType.FETCH_TXN_DETAIL);
		jobDto.setParamBeginDate(new Date(dates[0].toGregorianCalendar().getTimeInMillis()));
		jobDto.setParamEndDate(new Date(dates[1].toGregorianCalendar().getTimeInMillis()));
		jobDto.setJobStatus(DailyJobStatusDto.JobStatus.STARTED);
		jobDto = reportRepository.insertUpdateJobDescription(jobDto);

		List<Integer> entities = reportRepository.getMerchants();
		if(entities != null && !entities.isEmpty()) {
			List<CreditDebitTo> creditDebitRequests = new ArrayList<>();
			for(Integer entity : entities) {
				try {
					CreditDebitTo creditDebitRequest = new CreditDebitTo();
					creditDebitRequest.setBeginDate(jobStartDate);
					//end date time will be take care in next level of function
					creditDebitRequest.setEndDate(jobStartDate);
					creditDebitRequest.setEntityId(entity);
					creditDebitRequest.setLocationId(0);
					creditDebitRequest.setStoreId(Long.parseLong(storeId));
					creditDebitRequest.setStoreKey(storeKey);
					creditDebitRequests.add(creditDebitRequest);
				} catch (Exception e) {
					jobDto.setJobStatus(DailyJobStatusDto.JobStatus.COMP_ERROR);
					LOG.error("Error occurred during request preparation", e);
				}
			}
			
			if(!creditDebitRequests.isEmpty()) {
				List<CreditDebitResponse> responseList = profitStarsAdapter.getCreditAndDebitReports(creditDebitRequests, jobDto);
				//insert transaction detail into DB
				insertTransactionData(responseList, jobDto);
			}
		}

		//update data into the ACHPS_BILLING_JOB_DETAIL
		//no record fetched
		if (jobDto.getJobStatus() == JobStatus.STARTED) {
			jobDto.setJobStatus(JobStatus.COMPLETED);
		}
		reportRepository.insertUpdateJobDescription(jobDto);
		
		return jobDto.getJobStatus().toString();
	}

	/**
	 * @param responseList
	 * @param jobDto
	 * @return
	 */
	private DailyJobStatusDto insertTransactionData(List<CreditDebitResponse> responseList, DailyJobStatusDto jobDto) {
		LOG.info("insertTransactionData executing");
		if(responseList != null && !responseList.isEmpty()) {
			List<CreditDebitDetailsTo> requestList = new ArrayList<>();
			for(CreditDebitResponse response : responseList) {
				CreditDebitDetailsTo request = new CreditDebitDetailsTo(Long.parseLong(storeId), storeKey, response.getEntityId(), response.getBatchId());
				requestList.add(request);
			}

			List<CreditDebitTransaction> transactionList = profitStarsAdapter.getCreditAndDebitTxnDtlsReports(requestList, jobDto);
			//if transaction available
			if(transactionList != null && !transactionList.isEmpty()) {
				reportRepository.insertUpdateCreditDebitTransaction(transactionList, jobDto);
			}
		}
		return jobDto;
	}




	private void processProfileRecords(MerchantProfile profile, MonthlyBillingSummaryTo billingSummaryTo, List<MbsDailySummary> mbsDailySummaries,
			Map<String, MerchantPricing> merchantProfiles, Map<Integer, String> achElements) {
		LOG.info("Processing merchant profile: {}", profile.getEntityId() +"-" + profile.getLocationId() + "=" +profile.getMerchantNumber());
		ConcurrentHashMap<DailySummary, DailySummary> summaryMap = new ConcurrentHashMap<>();
		List<EventReport> eventReports = profitStarsAdapter.getMonthlyBillingSummary(billingSummaryTo);

		for(EventReport eventReport : eventReports) {
			DailySummary summary = new DailySummary();
			summary.setActivityDate(eventReport.getEventDate());
			summary.setEntityId(profile.getEntityId());

			String eventType = eventReport.getEventType();
			if("Originated".equals(eventType)) {
				summary.setItemDesc(achElements.get(224));
			} else if("Returned NSF".equals(eventType) || "Returned Bad Account".equals(eventType) || "Processing_Error".equals(eventType)) {
				summary.setItemDesc(achElements.get(225));
			} else if("Collected".equals(eventType) || "Charged Back".equals(eventType) || "Unauthorized".equals(eventType)) {
				summary.setItemDesc(achElements.get(226));
			} else {
				LOG.error("Unidentified transaction found!");
				continue;
			}

			DailySummary oldSummary = summaryMap.get(summary);
			if(oldSummary == null) {
				summary.setItemCount(1);
				summary.setItemAmount(eventReport.getAmount());

				if ("Sale".equals(eventReport.getOperationType())) {
					summary.setSalesCount(1);
					summary.setSalesAmount(eventReport.getAmount());
				} else {
					summary.setCreditCount(1);
					summary.setCreditAmount(eventReport.getAmount());
				}

				summaryMap.put(summary, summary);
			} else {
				oldSummary.setItemCount(oldSummary.getItemCount() + 1);
				oldSummary.setItemAmount(oldSummary.getItemAmount().add(eventReport.getAmount()));

				if ("Sale".equals(eventReport.getOperationType())) {
					oldSummary.setSalesCount(oldSummary.getSalesCount() + 1);
					oldSummary.setSalesAmount(oldSummary.getSalesAmount().add(eventReport.getAmount()));
				} else {
					oldSummary.setCreditCount(oldSummary.getCreditCount() + 1);
					oldSummary.setCreditAmount(oldSummary.getCreditAmount().add(eventReport.getAmount()));
				}
			}
		}
		LOG.info("EntityId: {}, LocationId: {}, Record count {}", "xxxx", "xxxx", summaryMap.size());

		for(Map.Entry<DailySummary, DailySummary> summary : summaryMap.entrySet()) {
			DailySummary dailySummary = summary.getKey();
			String key = dailySummary.getEntityId() + "#" + profile.getLocationId() + "#" +dailySummary.getItemDesc();
			MerchantPricing pricing = merchantProfiles.get(key);

			MbsDailySummary mbsSummary = new MbsDailySummary();
			mbsSummary.setMerchantNumber(pricing.getMerchNum());
			mbsSummary.setActivityDate(dailySummary.getActivityDate());
			mbsSummary.setItemType((int)pricing.getItemType());
			mbsSummary.setItemSubclass("AC");
			mbsSummary.setItemCount(dailySummary.getItemCount());
			mbsSummary.setItemAmount(dailySummary.getItemAmount());
			mbsSummary.setSalesCount(dailySummary.getSalesCount());
			mbsSummary.setSalesAmount(dailySummary.getSalesAmount());
			mbsSummary.setCreditCount(dailySummary.getCreditCount());
			mbsSummary.setCreditAmount(dailySummary.getCreditAmount());
			mbsSummary.setRate(pricing.getRate());
			mbsSummary.setPerItem(pricing.getPerItem());
			mbsSummary.setFeeDue(getFeesDue(pricing.getPerItem(), dailySummary.getItemCount(), pricing.getRate(), dailySummary.getItemAmount()));

			mbsDailySummaries.add(mbsSummary);
		}
	}
	
	/**
	 * This method used to calculate fees
	 * @param perItem
	 * @param itemCount
	 * @param rate
	 * @param itemAmount
	 * @return fees
	 */
	private BigDecimal getFeesDue(BigDecimal perItem, int itemCount, BigDecimal rate, BigDecimal itemAmount) {
		if (perItem == null) {
			perItem = BigDecimal.ZERO;
		}

		if (rate == null) {
			rate = BigDecimal.ZERO;
		}

		if (itemAmount == null) {
			itemAmount = BigDecimal.ZERO;
		}

		BigDecimal totalPerItemFees = perItem.multiply(BigDecimal.valueOf(itemCount));
		BigDecimal totalRateFees = rate.multiply(itemAmount).multiply(BigDecimal.valueOf(0.01));

		return totalPerItemFees.add(totalRateFees);
	}
}