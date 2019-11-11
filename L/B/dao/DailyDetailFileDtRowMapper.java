package com.mes.lcr.billing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mes.lcr.billing.dao.DailyDetailFileDTF;

public class DailyDetailFileDtRowMapper implements RowMapper<DailyDetailFileDTF> {

  @SuppressWarnings("nls")
@Override
  public DailyDetailFileDTF mapRow(ResultSet rs, int arg1) throws SQLException {

    DailyDetailFileDTF dailyDetailFileDT = new DailyDetailFileDTF();

    dailyDetailFileDT.setTransactionDate(rs.getDate("TRANSACTION_DATE"));
    dailyDetailFileDT.setTransactionAmount(rs.getDouble("AUTHORIZED_AMOUNT"));
    dailyDetailFileDT.setMoToIndicator(rs.getString("STND_IN_PROCESSING_ADVICE_CODE"));
    dailyDetailFileDT.setAuthCurrencyCode(rs.getLong("CURRENCY_CODE"));
    dailyDetailFileDT.setAuthAmt(rs.getDouble("AUTHORIZED_AMOUNT"));
    dailyDetailFileDT.setValidatCcode(rs.getString("VALIDATION_CODE"));
    dailyDetailFileDT.setAuthRresponCode(rs.getString("RESPONSE_CODE"));
    dailyDetailFileDT.setMerchantName(rs.getString("DBA_NAME"));
    dailyDetailFileDT.setAuthorizationNum(rs.getString("AUTHORIZATION_CODE"));
    dailyDetailFileDT.setCardType(rs.getString("CARD_TYPE"));
    dailyDetailFileDT.setCurrencyCode(rs.getString("CURRENCY_CODE"));
    dailyDetailFileDT.setOriginalTransactionAmount(rs.getDouble("AUTHORIZED_AMOUNT"));
    dailyDetailFileDT.setForeignCardIndicator(rs.getString("AUTH_INDICATOR"));
    dailyDetailFileDT.setMerchantAccountNumber(rs.getLong("MERCHANT_NUMBER"));
    dailyDetailFileDT.setProductId(rs.getString("PRODUCT_LEVEL_RESULT_CODE"));
    dailyDetailFileDT.setTridentTranId(rs.getString("TRIDENT_TRANSACTION_ID"));
    dailyDetailFileDT.setAuthRecId(rs.getLong("REC_ID"));
    dailyDetailFileDT.setBankNumber(rs.getLong("BANK_NUMBER"));
    dailyDetailFileDT.setOriginalCurrencyCode(rs.getString("CURRENCY_CODE"));
    dailyDetailFileDT.setLoadFilename(rs.getString("LOAD_FILENAME"));
    dailyDetailFileDT.setDdfDtId(rs.getLong("REC_ID"));
    dailyDetailFileDT.setBatchDate(rs.getDate("MERCHANT_BATCH_DATE"));
    dailyDetailFileDT.setBatchNumber(rs.getString("BATCH_ID"));
    dailyDetailFileDT.setMifDdaNum(rs.getString("DDA_NUM"));
    dailyDetailFileDT.setMifTransitRoutngNum(rs.getLong("TRANSIT_ROUTNG_NUM"));
    dailyDetailFileDT.setTcAcquirerBin(rs.getLong("ACQUIRER_BIN"));
    dailyDetailFileDT.setReferenceNumber(rs.getString("RETRIEVAL_REF_NUM"));
    dailyDetailFileDT.setMerchantBatchNumber(rs.getLong("BATCH_NUMBER"));
    dailyDetailFileDT.setMerchantId(rs.getString("CATID"));
    dailyDetailFileDT.setLoadFileId(rs.getLong("LOAD_FILE_ID"));

    return dailyDetailFileDT;
  }

}
