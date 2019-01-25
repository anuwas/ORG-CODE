package com.anu.BSN.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AcSettlementFileDTRRowMapperTest {
	
	@Mock
	private ResultSet rs;
	
	@InjectMocks
	AcclynkSettlementFileDTRRowMapper acclynkSettlementFileDTRRowMapper;
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void mapRowTest() throws SQLException{
		AcclynkSettlementFileDTR acclynkSettlementFileDTR = acclynkSettlementFileDTRRowMapper.mapRow(rs, 1);
		Assert.assertEquals(0, acclynkSettlementFileDTR.getDtrSeqNum());
		Assert.assertEquals(0, acclynkSettlementFileDTR.getMerchantNumber());
		Assert.assertEquals(0.0, acclynkSettlementFileDTR.getSwitchfee(),0);
	}
}
