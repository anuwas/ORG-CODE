package com.mes.lcr.billing.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.mes.lcr.billing.dao.AcculynkBillingRepository;
import com.mes.lcr.billing.dao.AchDetails;
import com.mes.lcr.billing.dao.DailyDetailFileDTF;
import com.mes.lcr.billing.dto.AcckFundingResponse;
import com.mes.lcr.util.DateTimeUtil;
import com.mes.lcr.util.NumberUtil;

@Component
public class AcculynkServiceImpl implements AcculynkService {

	private static final Logger LOG = LoggerFactory.getLogger(AcculynkServiceImpl.class);
	public static final String DATEFORMAT = "dd/MM/yyyy"; //$NON-NLS-1$

	@Autowired
	private AcculynkBillingRepository acculynkBillingRepository;
	@Autowired
	private LcrDailyBillingService lcrDailyBillingService;

	@SuppressWarnings("nls")
	@Override
	public String dailyBillingJob(String loadfileDate) {
		String returnStatus = "success";
		try {
			LOG.info("Started daily billing job on ({}) {} , for loadfileDate ({}) {} ", DATEFORMAT, DateTimeUtil.getCurrentDateTime(DATEFORMAT), DATEFORMAT, loadfileDate);
			List<String> dailyBillingLoadFileNames = this.acculynkBillingRepository.getListofSettlementFilesnotBilled(loadfileDate);
			if (dailyBillingLoadFileNames != null && !dailyBillingLoadFileNames.isEmpty()) {
				dailyBillingLoadFileNames.forEach(lcrDailyBillingService);
				LOG.info("LCR Daily Billing job completed for the date of ({}){}, loadfile Date ({}){}, files {} ", DATEFORMAT, DateTimeUtil.getCurrentDateTime(DATEFORMAT), DATEFORMAT, loadfileDate, dailyBillingLoadFileNames);
			}
			else {
				LOG.info("Daily Billing Service already completed for the date of ({}){}, loadfile Date ({}){} ", DATEFORMAT, DateTimeUtil.getCurrentDateTime(DATEFORMAT), DATEFORMAT, loadfileDate);
			}
		}
		catch (Exception ex) {
			LOG.error("Billing Service execution error on ({}){} , Exception", DATEFORMAT, DateTimeUtil.getCurrentDateTime(DATEFORMAT), ex);
			returnStatus = "failed";
		}
		return returnStatus;
	}

	@SuppressWarnings("nls")
	@Override
	public void acculynkFundingJob() {
		LOG.info("ACCULYNK Funding table loading process starts ...");
		java.sql.Date batchDate = null;
		String loadFileName = null;
		Set<String> fileList = new HashSet<>();
		long loadFileId = 0;

		List<DailyDetailFileDTF> dailyDetailFileDTs = new ArrayList<DailyDetailFileDTF>();
		dailyDetailFileDTs = this.acculynkBillingRepository.getDailyDetailFundingList();
		List<DailyDetailFileDTF> dailyDetailFileDTList = new ArrayList<>();
		List<AchDetails> achDetaillist = new ArrayList<>();
		int detailBatchId = 1;
		if (dailyDetailFileDTs != null && !dailyDetailFileDTs.isEmpty()) {
			batchDate = dailyDetailFileDTs.get(0).getBatchDate();
			loadFileName = generateLoadFileName(dailyDetailFileDTs.get(0).getBankNumber());
			loadFileId = this.acculynkBillingRepository.callLoadFileIndex(loadFileName);
			fileList.add(loadFileName);
		}

		for (DailyDetailFileDTF detailFileDT : dailyDetailFileDTs) {

			detailFileDT.setIcPaid(0);
			detailFileDT.setIcExpense(0);
			detailFileDT.setIcExpenseEnhanced(0);
			detailFileDT.setDailyDiscountInterchange("0");
			detailFileDT.setDiscountAmount(0);
			detailFileDT.setDiscountPaid(0);
			detailFileDT.setDiscountRate(0);
			detailFileDT.setDebitCreditIndicator("D");
			detailFileDT.setAchFlag("Y");

			detailFileDT.setLoadFilename(loadFileName);
			detailFileDT.setLoadFileId(loadFileId);

			AcckFundingResponse acckFundingResponse = new AcckFundingResponse();
			acckFundingResponse.setDetailFileDTF(detailFileDT);
			List<AcckFundingResponse> acckFundingResponses = new ArrayList<>();
			acckFundingResponses.add(acckFundingResponse);

			dailyDetailFileDTList.add(detailFileDT);

			AchDetails achDetails = new AchDetails();

			achDetails.setMerchantNumber(detailFileDT.getMerchantAccountNumber());
			achDetails.setRecordTypeCode("6");
			achDetails.setTransactionCode(22);
			achDetails.setReceivingDfiIdTtttaaaac(String.valueOf(detailFileDT.getMifTransitRoutngNum()));
			achDetails.setDfiAccountNumberDdaNumber(detailFileDT.getMifDdaNum());
			achDetails.setAmountOfTransaction(detailFileDT.getTransactionAmount());
			achDetails.setInternalAccountNumber(String.valueOf(detailFileDT.getMerchantAccountNumber()));
			if(!StringUtils.isEmpty(detailFileDT.getMerchantName()) && detailFileDT.getMerchantName().length()>22){
				achDetails.setIndividualName(detailFileDT.getMerchantName().substring(0,22));
			}else{
				achDetails.setIndividualName(detailFileDT.getMerchantName());	
			}
			achDetails.setAddendaRecordIndicator("0");
			achDetails.setFileCreationDate(detailFileDT.getTransactionDate());
			achDetails.setBatchNumber(1);
			achDetails.setPostDateOption(detailFileDT.getTransactionDate());
			achDetails.setBatchDetailId(detailBatchId);
			achDetails.setBatchId(Long.parseLong(detailFileDT.getBatchNumber()));
			achDetails.setFxReferenceNumber(detailFileDT.getReferenceNumber());
			achDetails.setLoadFilename(detailFileDT.getLoadFilename());
			detailBatchId++;
			achDetaillist.add(achDetails);

		}

		if (!CollectionUtils.isEmpty(dailyDetailFileDTList)) {
			LOG.debug("ACCULYNK funding daily detail DT Table Loading starts");
			this.acculynkBillingRepository.acckFundingDailyDetailDtInsertProcess(dailyDetailFileDTList);

			LOG.debug("ACCULYNK funding daily detail DT Table Loaded Successfully");

			LOG.debug("ACCULYNK funding Details Table Loading starts");
			if (!CollectionUtils.isEmpty(achDetaillist)) {
				this.acculynkBillingRepository.acckFundingAchDetailInsertProcess(achDetaillist);

			}
			LOG.debug("ACCULYNK funding Details Table Loaded Successfully");

			LOG.debug("ACCULYNK funding Summary Table Loading started");
			for (String fileName : fileList) {
				this.acculynkBillingRepository.loadACHSummary(fileName);
			}
			LOG.debug("ACCULYNK funding Summary Table Loaded Successfully");

			LOG.debug("DAILY_DETAIL_FILE_DT_PROCESS Table Loading started");
			if (batchDate != null) {
				this.acculynkBillingRepository.insertIntoDtProcess(0, 2, loadFileName, batchDate);
			}
			LOG.debug("DAILY_DETAIL_FILE_DT_PROCESS Table Loaded Successfully");
		}

		LOG.info("ACCULYNK Funding table loadeding process end ...");
	}

	private synchronized String generateLoadFileName(long bankNumber) {
		String ext = ".dat";
		StringBuilder loadFilename = new StringBuilder("lcr" + bankNumber);
		String dateString = new SimpleDateFormat("MMddyy").format(new Date(System.currentTimeMillis()));
		Integer fileSeqNo = generateFileIdSequence(loadFilename.toString(), dateString);
		String strFileSeqNo = NumberUtil.getPaddedLong(fileSeqNo, 3);
		loadFilename.append("_");
		loadFilename.append(dateString);
		loadFilename.append("_");
		loadFilename.append(strFileSeqNo);
		loadFilename.append(ext);
		return (loadFilename.toString());
	}

	private Integer generateFileIdSequence(String fileType, String dateString) {
		return this.acculynkBillingRepository.generateFileIdSequence(fileType, dateString);
	}

	@Override
	public String clearDailyBillingDataByDateAPI(String loadfileDate) {
		List<String> loadfileNames = this.acculynkBillingRepository.getListofSettlementFilesToClear(loadfileDate);
		return (this.acculynkBillingRepository.cleanAcculynkDailyBillingDataByLoadfileDate(loadfileDate, loadfileNames)) ? "success" : "fail";
	}

}
