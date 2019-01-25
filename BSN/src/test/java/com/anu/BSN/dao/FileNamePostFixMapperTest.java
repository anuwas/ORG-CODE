package com.me.lc.bil.dao;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class FileNamePostFixMapperTest {
	
	@Mock
	private ResultSet rs;
	
	@InjectMocks
	FileNamePostFixMapper fileNamePostFixMapper;
	
	@Test
	public void mapRowTest() throws Exception{
		
		List<Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
		
        
		FileNamePostFix filenamepostfix = fileNamePostFixMapper.mapRow(mockResultSet(lst),1);
		Assert.assertEquals(null, filenamepostfix.getFileType());
		Assert.assertEquals(0, filenamepostfix.getFileId(),0);
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
