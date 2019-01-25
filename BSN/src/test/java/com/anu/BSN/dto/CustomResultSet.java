package com.mes.lcr.billing.dto;

import java.sql.ResultSet;
import java.util.List;
import com.mockrunner.mock.jdbc.MockResultSet;

public class CustomResultSet {
	
	public ResultSet getResultSet(List<String> headers, List<List<Object>> data) throws Exception {
		 
        // validation
        if (headers == null || data == null) {
            throw new Exception("null parameters");
        }
 
        if (headers.size() != data.size()) {
            throw new Exception("parameters size are not equals");
        }
 
        // create a mock result set
        MockResultSet mockResultSet = new MockResultSet("customResultSet");
 
        // add header
        for (String string : headers) {         
            mockResultSet.addColumn(string);
        }
 
        // add data
        for (List<Object> list : data) {
            mockResultSet.addRow(list);
        }
 
        return mockResultSet;
    }
    
}
