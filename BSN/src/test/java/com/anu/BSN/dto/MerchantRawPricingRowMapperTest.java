package com.me.lc.billing.dto;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.me.lc.billing.dao.mbPricing;

@RunWith(SpringJUnit4ClassRunner.class)
public class MerchantRawPricingRowMapperTest {
	
	@Mock
	private ResultSet rs;
	
	@InjectMocks
	MerchantRawPricingRowMapper merchantRawPricingRowMapper;
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void extractDataTest() throws Exception{
		
		List<Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
		merchantRawPricingRowMapper.extractData(mockResultSet(lst));
		Map<String, mbPricing> rawPricingMapper1  = merchantRawPricingRowMapper.extractData(provideResultSet1());
		mbPricing mbPricing1 = rawPricingMapper1.get("943300112-VP-227");
		Assert.assertEquals(943300112L, mbPricing1.getMerchantNumber());
		Assert.assertEquals(227, mbPricing1.getItemType());
		Assert.assertEquals("VP", mbPricing1.getItemSubclass());
        merchantRawPricingRowMapper.extractData(provideResultSet2());
        merchantRawPricingRowMapper.extractData(provideResultSet3());
        merchantRawPricingRowMapper.extractData(provideResultSet4());
        merchantRawPricingRowMapper.extractData(provideResultSet5());
        merchantRawPricingRowMapper.extractData(provideResultSet6());
        merchantRawPricingRowMapper.extractData(provideResultSet7());
        merchantRawPricingRowMapper.extractData(provideResultSet8());
        Map<String, mbPricing> rawPricingMapper9  = merchantRawPricingRowMapper.extractData(provideResultSet9());
        Assert.assertEquals(new HashMap<>(), rawPricingMapper9);
        
	}
	
	private  ResultSet provideResultSet1() throws Exception {
		CustomResultSet myResultSet = new CustomResultSet();
        List<String> headers = new ArrayList<String>();
		
        headers.add("MERCHANT_NUMBER");
        headers.add("ITEM_SUBCLASS");
        headers.add("RATE");
        headers.add("PER_ITEM");
        headers.add("ITEM_TYPE");
        
        List<List<Object>> data = new ArrayList<List<Object>>();
        for (int i = 0; i < 5; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(new Long(943300112));
            objects.add("VP");
            objects.add(new Double(1.0));
            objects.add(new Double(1.0));
            objects.add(new Integer(227));
            
            data.add(objects);
        }
        ResultSet customRS = myResultSet.getResultSet(headers, data);
        return customRS;
	}
	
	private ResultSet provideResultSet2() throws Exception
	{
		CustomResultSet myResultSet = new CustomResultSet();
        List<String> headers = new ArrayList<String>();
		
        headers.add("MERCHANT_NUMBER");
        headers.add("ITEM_SUBCLASS");
        headers.add("RATE");
        headers.add("PER_ITEM");
        headers.add("ITEM_TYPE");
        
        List<List<Object>> data = new ArrayList<List<Object>>();
        for (int i = 0; i < 5; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(new Long(943300112));
            objects.add("VP");
            objects.add(0);
            objects.add(0);
            objects.add(0);
            
            data.add(objects);
        }
        
        ResultSet customRS = myResultSet.getResultSet(headers, data);
        return customRS;
	}
	
	private ResultSet provideResultSet3() throws Exception
	{
		CustomResultSet myResultSet = new CustomResultSet();
        List<String> headers = new ArrayList<String>();
		
        headers.add("MERCHANT_NUMBER");
        headers.add("ITEM_SUBCLASS");
        headers.add("RATE");
        headers.add("PER_ITEM");
        headers.add("ITEM_TYPE");
        
        List<List<Object>> data = new ArrayList<List<Object>>();
        for (int i = 0; i < 5; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(new Long(943300112));
            objects.add(null);
            objects.add(0);
            objects.add(0);
            objects.add(0);
            
            data.add(objects);
        }
        
        ResultSet customRS = myResultSet.getResultSet(headers, data);
        return customRS;
	}
	
	private ResultSet provideResultSet4() throws Exception
	{
		CustomResultSet myResultSet = new CustomResultSet();
        List<String> headers = new ArrayList<String>();
		
        headers.add("MERCHANT_NUMBER");
        headers.add("ITEM_SUBCLASS");
        headers.add("RATE");
        headers.add("PER_ITEM");
        headers.add("ITEM_TYPE");
        
        List<List<Object>> data = new ArrayList<List<Object>>();
        for (int i = 0; i < 5; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(new Long(943300112));
            objects.add(null);
            objects.add(0);
            objects.add(0);
            objects.add(new Integer(227));
            
            data.add(objects);
        }
        
        ResultSet customRS = myResultSet.getResultSet(headers, data);
        return customRS;
	}
	
	private ResultSet provideResultSet5() throws Exception
	{
		CustomResultSet myResultSet = new CustomResultSet();
        List<String> headers = new ArrayList<String>();
		
        headers.add("MERCHANT_NUMBER");
        headers.add("ITEM_SUBCLASS");
        headers.add("RATE");
        headers.add("PER_ITEM");
        headers.add("ITEM_TYPE");
        
        List<List<Object>> data = new ArrayList<List<Object>>();
        for (int i = 0; i < 5; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(0);
            objects.add("VP");
            objects.add(0);
            objects.add(0);
            objects.add(0);
            
            data.add(objects);
        }
        
        ResultSet customRS = myResultSet.getResultSet(headers, data);
        return customRS;
	}
	
	private ResultSet provideResultSet6() throws Exception
	{
		CustomResultSet myResultSet = new CustomResultSet();
        List<String> headers = new ArrayList<String>();
		
        headers.add("MERCHANT_NUMBER");
        headers.add("ITEM_SUBCLASS");
        headers.add("RATE");
        headers.add("PER_ITEM");
        headers.add("ITEM_TYPE");
        
        List<List<Object>> data = new ArrayList<List<Object>>();
        for (int i = 0; i < 5; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(new Long(943300112));
            objects.add("VP");
            objects.add(0);
            objects.add(0);
            objects.add(0);
            
            data.add(objects);
        }
        
        ResultSet customRS = myResultSet.getResultSet(headers, data);
        return customRS;
	}
	
	private ResultSet provideResultSet7() throws Exception
	{
		CustomResultSet myResultSet = new CustomResultSet();
        List<String> headers = new ArrayList<String>();
		
        headers.add("MERCHANT_NUMBER");
        headers.add("ITEM_SUBCLASS");
        headers.add("RATE");
        headers.add("PER_ITEM");
        headers.add("ITEM_TYPE");
        
        List<List<Object>> data = new ArrayList<List<Object>>();
        for (int i = 0; i < 5; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(0);
            objects.add("VP");
            objects.add(0);
            objects.add(0);
            objects.add(new Integer(227));
            
            data.add(objects);
        }
        
        ResultSet customRS = myResultSet.getResultSet(headers, data);
        return customRS;
	}
	
	private ResultSet provideResultSet8() throws Exception
	{
		CustomResultSet myResultSet = new CustomResultSet();
        List<String> headers = new ArrayList<String>();
		
        headers.add("MERCHANT_NUMBER");
        headers.add("ITEM_SUBCLASS");
        headers.add("RATE");
        headers.add("PER_ITEM");
        headers.add("ITEM_TYPE");
        
        List<List<Object>> data = new ArrayList<List<Object>>();
        for (int i = 0; i < 5; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(0);
            objects.add(null);
            objects.add(0);
            objects.add(0);
            objects.add(new Integer(227));
            
            data.add(objects);
        }
        
        ResultSet customRS = myResultSet.getResultSet(headers, data);
        return customRS;
	}
	
	private ResultSet provideResultSet9() throws Exception
	{
		CustomResultSet myResultSet = new CustomResultSet();
        List<String> headers = new ArrayList<String>();
		
        headers.add("MERCHANT_NUMBER");
        headers.add("ITEM_SUBCLASS");
        headers.add("RATE");
        headers.add("PER_ITEM");
        headers.add("ITEM_TYPE");
        
        List<List<Object>> data = new ArrayList<List<Object>>();
        for (int i = 0; i < 5; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(new Long(943300112));
            objects.add(null);
            objects.add(0);
            objects.add(0);
            objects.add(new Integer(227));
            
            data.add(objects);
        }
        
        ResultSet customRS = myResultSet.getResultSet(headers, data);
        return customRS;
	}
	
	private ResultSet mockResultSet(List<Integer> rows) throws SQLException {
	    ResultSet rs = mock(ResultSet.class);
	    
	    OngoingStubbing rsNextStub = when(rs.next());
	    for (Integer i : rows) {
	        // We must reassign!
	        rsNextStub = rsNextStub.thenReturn(true);
	    }
	    rsNextStub.thenReturn(false);
	    
	    OngoingStubbing rsGetIntStub = when(rs.getInt(1));
	    for (Integer i : rows) {
	        // We must reassign!
	        rsGetIntStub = rsGetIntStub.thenReturn(i);
	    }
	    
	    return rs;
	}

}
