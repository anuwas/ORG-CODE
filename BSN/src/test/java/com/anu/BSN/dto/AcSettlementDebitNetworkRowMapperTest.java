package com.anu.BSN.dto;

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
import com.mes.lcr.billing.dao.AcclynkSettlementFileDTR;

@RunWith(SpringJUnit4ClassRunner.class)
public class AcSettlementDebitNetworkRowMapperTest {
	
	@Mock
	private ResultSet rs;
	
	@InjectMocks
	AcclynkSettlementDebitNetworkRowMapper acclynkSettlementDebitNetworkRowMapper;
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void mapRowTest() throws SQLException{
		AcclynkSettlementFileDTR acclynkSettlementFileDTRObj = acclynkSettlementDebitNetworkRowMapper.mapRow(rs, 1);
		Assert.assertEquals(0, acclynkSettlementFileDTRObj.getDtrSeqNum());
		Assert.assertEquals(0.0, acclynkSettlementFileDTRObj.getSwitchfee(),0);
		
	}

}
