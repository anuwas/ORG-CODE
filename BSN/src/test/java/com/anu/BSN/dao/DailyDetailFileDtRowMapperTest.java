package com.mes.lcr.billing.dao;

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
public class DailyDetailFileDtRowMapperTest {
	
	@Mock
	private ResultSet rs;
	
	@InjectMocks
	DailyDetailFileDtRowMapper dailyDetailFileDtRowMapper;
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void mapRowTest() throws SQLException{
		DailyDetailFileDTF mappedObj = dailyDetailFileDtRowMapper.mapRow(rs, 1);
		Assert.assertEquals(null, mappedObj.getReferenceKey());
		Assert.assertEquals(0, mappedObj.getAssociationNum());
		Assert.assertEquals(0.0, mappedObj.getTransactionAmount(),0);
	}

}
