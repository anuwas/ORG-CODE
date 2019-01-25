package com.anu.BSN.dto;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AcDtrHdrDataCountTest {

	@Mock
	private ResultSet rs;
	
	@InjectMocks
	AcDtrHdrDataCount AcDtrHdrDataCount;
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void extractDataTest() throws Exception {
		boolean status = false;
		List<Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
		status = AcDtrHdrDataCount.extractData(mockResultSet(lst));
		Assert.assertEquals(true, status);
		
		CustomResultSet myResultSet = new CustomResultSet();
        List<String> headers = new ArrayList<String>();
        headers.add("HDR_COUNT");
        headers.add("DTR_COUNT");
        
        List<List<Object>> data = new ArrayList<List<Object>>();
        for (int i = 0; i < 2; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(new Integer(i));
            objects.add(new Integer(2));            
            data.add(objects);
        }
        
        ResultSet customRS = myResultSet.getResultSet(headers, data);
        status = AcDtrHdrDataCount.extractData(customRS);
        Assert.assertEquals(false, status);
        
        List<List<Object>> data2 = new ArrayList<List<Object>>();
        for (int i = 0; i < 2; i++) {
            List<Object> objects = new ArrayList<Object>();

            objects.add(new Integer(2));
            objects.add(new Integer(2));            
            data2.add(objects);
        }
        ResultSet customRS2 = myResultSet.getResultSet(headers, data2);
        status = AcDtrHdrDataCount.extractData(customRS2);
        Assert.assertEquals(true, status);
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
