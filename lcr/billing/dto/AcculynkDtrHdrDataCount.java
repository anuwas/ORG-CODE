package com.mes.lcr.billing.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class AcculynkDtrHdrDataCount implements ResultSetExtractor<Boolean>{
	static final Logger LOG = LoggerFactory.getLogger(AcculynkDtrHdrDataCount.class);
	@Override
	public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
		boolean status = false;
		while(rs.next()) {
			int hdrCount=rs.getInt("HDR_COUNT");
			int dtrCount=rs.getInt("DTR_COUNT");
			if(hdrCount==dtrCount) {
				LOG.debug("Comparing HDR count {} and DTR count {} ",hdrCount,dtrCount);
				status = true;
			}
		}
		return status;
	}
}
