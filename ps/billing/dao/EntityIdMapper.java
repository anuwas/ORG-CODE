package com.mes.ps.billing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * RowMapper implementation for Entity ID
 */
public class EntityIdMapper implements RowMapper<ACHPProfilesDTO> {

	@Override
	public ACHPProfilesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ACHPProfilesDTO dto = new ACHPProfilesDTO();

		dto.setEntityId(rs.getString("ENTITY_ID"));

		return dto;
	}
}