package com.mes.lcr.billing.dao;


import java.util.List;
import java.util.Map;
import com.mes.lcr.billing.dto.PinlessDebitNetworkFees;

public interface AcculynkBillingRepository {


  Long callLoadFileIndex(String loadFilename);
  /**
  *
  */
  List<AcclynkSettlementFileDTR> getAcculynkSettlementDTRZeroDebitNetwork(String loadfileDate);
  /**
   * Method to return batch details list for payment gateway and trident batch
   * return list of PG Batch Details
   */
  List<DailyDetailFileDTF> getDailyDetailFundingList();
  /**
  *
  */
  void acckFundingDailyDetailDtInsertProcess(List<DailyDetailFileDTF> dailyDetailFileDTs);
  /**
  *
  */
  void acckFundingAchDetailInsertProcess(List<AchDetails> achDetails);
  /**
  *
  */
  void loadACHSummary(String loadFileName);
  /**
  *
  */
  public List<PinlessDebitNetworkFees> getPinlessDebitNetWrorkFees();
  /**
  *
  */
  public void updateSettlementDTRZeroDebitNetwork(List<AcclynkSettlementFileDTR> dailyDetailFileDtList);
  /**
  *
  */
  void insertIntoDtProcess(long processSequence,int processType,String loadFileName,java.sql.Date batchDate);
  /**
  *
  */
  public List<Long> getParnterMerchants(long groupId);
  /**
  *Method To Generate Sequential file id for loadfilename
  *@param String fileType
  *@param String dateString
  *return sequential fileid for loadfilename
  */
  public Integer generateFileIdSequence(String fileType,String dateString);
  /**
   *
   */
   public List<AcclynkSettlementFileDTR> getSettlementDataFromLoadfileName(String loadfileName);
   /**
   *
   */
   public void insertIncomeExpenseIntoMbsDailySummary(List<MBSDailySummaryIncomeExpense> mbsDailySummaryIncomeExpenselist);
   /**
   *
   */
   public boolean cleanAcculynkDailyBillingDataByLoadfileDate(String loadfileDate,List<String> loadfileNames);
   /**
   *
   */
   public List<String> getListofSettlementFilesnotBilled(String loadfileDate);
   /**
   *
   */
   public List<String> getListofSettlementFilesToClear(String loadfileDate);
   /**
   *
   */
   public Map<String,MbsPricing> getMerchantRawPricingFromLoadfile(String loadfileName);
   /**
   *
   */
   public Map<String, DailyDetailFileICDesc> getDailyDetailFileICDescVpMp();
   /**
   *
   */
   public void updateBillingJobStatusForaFile(String jobStatus, String loadfileName);
}
