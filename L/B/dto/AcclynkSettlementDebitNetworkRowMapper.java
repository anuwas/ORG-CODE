package com.mes.lcr.billing.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mes.lcr.billing.dao.AcclynkSettlementFileDTR;

public class AcclynkSettlementDebitNetworkRowMapper implements RowMapper<AcclynkSettlementFileDTR> {

	  @SuppressWarnings("nls")
	  @Override
	    public AcclynkSettlementFileDTR mapRow(ResultSet rs, int rowNum) throws SQLException {

	      AcclynkSettlementFileDTR acclynkSettlementFileDTR = new AcclynkSettlementFileDTR();
	      acclynkSettlementFileDTR.setDtrSeqNum(rs.getLong("DTR_SEQ_NUM"));
	      acclynkSettlementFileDTR.setSwitchfee(rs.getDouble("SWITCHFEE"));
	      acclynkSettlementFileDTR.setNetworkfee(rs.getDouble("NETWORKFEE"));
	      acclynkSettlementFileDTR.setCardtype(rs.getString("CARD_TYPE"));
	      acclynkSettlementFileDTR.setTransactionDateTime(rs.getDate("TRANSACTION_DATETIME"));
	      acclynkSettlementFileDTR.setInterchangeFee(rs.getDouble("INTERCHANGE_FEE"));
	      acclynkSettlementFileDTR.setTransactionAmount(rs.getDouble("TRANSACTION_AMT"));
	      acclynkSettlementFileDTR.setApprovalAmount(rs.getDouble("APPROVAL_AMT"));
	      acclynkSettlementFileDTR.setNetwork(rs.getString("NETWORK"));
	      return acclynkSettlementFileDTR;
	    }
}
