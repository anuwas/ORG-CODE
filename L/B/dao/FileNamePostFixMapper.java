package com.mes.lcr.billing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FileNamePostFixMapper implements RowMapper<FileNamePostFix> {
	@SuppressWarnings("nls")
	@Override
	public FileNamePostFix mapRow(ResultSet rs, int arg1) throws SQLException {
		FileNamePostFix fileNamePostFix = new FileNamePostFix();
		fileNamePostFix.setDateString(rs.getString("LAST_DATE"));
		fileNamePostFix.setFileId(rs.getInt("LAST_COUNT"));	
		return fileNamePostFix;
	}
}
