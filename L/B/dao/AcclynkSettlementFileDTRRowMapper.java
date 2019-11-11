package com.mes.lcr.billing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AcclynkSettlementFileDTRRowMapper implements RowMapper<AcclynkSettlementFileDTR> {

  @SuppressWarnings("nls")
@Override
  public AcclynkSettlementFileDTR mapRow(ResultSet rs, int rowNum) throws SQLException {

    AcclynkSettlementFileDTR acclynkSettlementFileDTR = new AcclynkSettlementFileDTR();
    acclynkSettlementFileDTR.setMerchantNumber(rs.getLong("MERCHANT_NUMBER"));
    acclynkSettlementFileDTR.setSwitchfee(rs.getDouble("SWITCHFEE"));
    acclynkSettlementFileDTR.setNetworkfee(rs.getDouble("NETWORKFEE"));
    acclynkSettlementFileDTR.setCardtype(rs.getString("CARD_TYPE"));
    acclynkSettlementFileDTR.setTransactionDateTime(rs.getDate("TRANSACTION_DATETIME"));
    acclynkSettlementFileDTR.setInterchangeFee(rs.getDouble("INTERCHANGE_FEE"));
    acclynkSettlementFileDTR.setDiscountFee(rs.getDouble("DISCOUNTFEE"));
    acclynkSettlementFileDTR.setSalesCount(rs.getInt("SALES_COUNT"));
    acclynkSettlementFileDTR.setSalesAmount(rs.getDouble("SALES_AMOUNT"));
    acclynkSettlementFileDTR.setCreditCount(rs.getInt("CREDITS_COUNT"));
    acclynkSettlementFileDTR.setCreditAmount(rs.getDouble("CREDITS_AMOUNT"));
    acclynkSettlementFileDTR.setItemCount(rs.getInt("ITEM_COUNT"));
    acclynkSettlementFileDTR.setItemAmount(rs.getDouble("ITEM_AMOUNT"));
    acclynkSettlementFileDTR.setLoadFilename(rs.getString("LOAD_FILENAME"));
    acclynkSettlementFileDTR.setLoadFileId(rs.getLong("LOAD_FILE_ID"));
    acclynkSettlementFileDTR.setBatchDate(rs.getDate("BATCH_DATE"));
    acclynkSettlementFileDTR.setNetwork(rs.getString("NETWORK"));
    acclynkSettlementFileDTR.setRegulatedIndicator(rs.getString("REGULATED_INDICATOR"));
    return acclynkSettlementFileDTR;
  }

}
