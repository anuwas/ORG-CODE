package com.me.lc.billing.dto;

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
public class PinlessDebitNetworkFeesRowMapperTest {

	@Mock
	private ResultSet rs;
	
	@InjectMocks
	PinlessDebitNetworkFeesRowMapper pinlessDebitNetworkFeesRowMapper;
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void mapRowTest() throws SQLException{
		PinlessDebitNetworkFees pinlessDebitNetworkFees = pinlessDebitNetworkFeesRowMapper.mapRow(rs, 1);
		Assert.assertEquals(0, pinlessDebitNetworkFees.getRecId());
		Assert.assertEquals(null, pinlessDebitNetworkFees.getNetwork());
	}
	
}
