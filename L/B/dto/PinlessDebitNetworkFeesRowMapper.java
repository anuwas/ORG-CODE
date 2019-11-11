package com.mes.lcr.billing.dto;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class PinlessDebitNetworkFeesRowMapper implements RowMapper<PinlessDebitNetworkFees>{

	 @SuppressWarnings("nls")
	  @Override
	    public PinlessDebitNetworkFees mapRow(ResultSet rs, int rowNum) throws SQLException {

		 PinlessDebitNetworkFees pinlessDebitNetworkFees = new PinlessDebitNetworkFees();
		 pinlessDebitNetworkFees.setRecId(rs.getInt("REC_ID"));
		 pinlessDebitNetworkFees.setNetwork(rs.getString("NETWORK"));
		 pinlessDebitNetworkFees.setRate(rs.getDouble("RATE"));
		 pinlessDebitNetworkFees.setPerItem(rs.getDouble("PER_ITEM"));
	      return pinlessDebitNetworkFees;
	    }
}
