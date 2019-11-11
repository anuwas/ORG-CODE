package com.mes.ps.billing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * RowMapper implementation for Merchant Data
 */
public class MerchantDataMapper implements RowMapper<ACHPProfilesDTO> {
	
	@Override
	public ACHPProfilesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ACHPProfilesDTO dto = new ACHPProfilesDTO();
		
		dto.setProfileId(rs.getString("PROFILE_ID"));
		dto.setMerchNum(rs.getString("MERCH_NUM"));
		dto.setMerchName(rs.getString("MERCH_NAME"));
		dto.setCompanyName(rs.getString("COMPANY_NAME"));
		
		return dto;
	}

}