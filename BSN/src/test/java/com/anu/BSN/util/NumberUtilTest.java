package com.mes.lc.billing.util;

import java.lang.reflect.Constructor;
import org.junit.Assert;
import org.junit.Test;
import com.mes.lc.util.NumberUtil;

public class NumberUtilTest {

	@Test
	public void getPaddedLongTest() {
		String val1 = NumberUtil.getPaddedLong(0, 0);
		Assert.assertEquals("0",val1);
		String val2 = NumberUtil.getPaddedLong(1234, 2);
		Assert.assertEquals("1234",val2);
		String val3 = NumberUtil.getPaddedLong(12, 5);
		Assert.assertEquals("00012",val3);
		String val4 = NumberUtil.getPaddedLong(12, 3);
		Assert.assertEquals("012",val4);
	}
	
	@Test
	public void checkPrivateConstructor(){
		try {
			Constructor<NumberUtil> c = NumberUtil.class.getDeclaredConstructor();
			c.setAccessible(true); 
			NumberUtil bu = c.newInstance();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
