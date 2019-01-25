package com.mes.lc.billing.dto;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.mes.lc.billing.dao.DailyDetailFileICDesc;

@RunWith(SpringJUnit4ClassRunner.class)
public class DailyDetailFileICDescRowMapperTest {
	
	@Mock
	private ResultSet rs;
	
	@InjectMocks
	DailyDetailFileICDescRowMapper dailyDetailFileICDescRowMapper;
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void extractDataTest() throws Exception{
		List<Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
		dailyDetailFileICDescRowMapper.extractData(mockResultSet(lst));
		
		CustomResultSet myResultSet = new CustomResultSet();
        List<String> headers = new ArrayList<String>();
        headers.add("REC_ID");
        headers.add("CARD_TYPE");
        headers.add("IC_CODE");
        headers.add("IC_DESC");
        headers.add("IC_RATE");
        headers.add("IC_PER_ITEM");
        headers.add("VALID_DATE_BEGIN");
        headers.add("VALID_DATE_END");
        headers.add("REG_IC_CODE");
        headers.add("BASE_RATE");
        headers.add("BASE_PER_ITEM");
        
        List<List<Object>> data = new ArrayList<List<Object>>();
        for (int i = 0; i < 11; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(new Integer(i));
            objects.add("VP");
            objects.add("101");
            objects.add("XCEL - Unregulated");
            objects.add(new Double(1.0));
            objects.add(new Double(1.0));
            objects.add(new Date(i));
            objects.add(new Date(i));
            objects.add("REG_IC_CODE");
            objects.add(new Double(1.0));
            objects.add(new Double(1.0));
            
            data.add(objects);
        }
        
        ResultSet customRS = myResultSet.getResultSet(headers, data);
        
        Map<String, DailyDetailFileICDesc> dailyDetailFileICDescMap = dailyDetailFileICDescRowMapper.extractData(customRS);
        DailyDetailFileICDesc dailyDetailFileICDescObj = dailyDetailFileICDescMap.get("VPXCELU");
        Assert.assertEquals("VP", dailyDetailFileICDescObj.getCardType());
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
