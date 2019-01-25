package com.me.lc.billing.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.me.ps.billing.config.TestConfig;

@ContextConfiguration(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PartnerConfigTest {

	@Autowired
	private PartnerConfig partnerConfig;
	
	@Test
	public void getSwitchfeeconfigTest() {
		List<Long> keyList = new ArrayList<>();
		List<Double> valueList = new ArrayList<>();
		
		Map<Long,Double> partnerConfigInputMap = partnerConfig.getSwitchfeeconfig();
		
		for(Entry<Long, Double> obj : partnerConfigInputMap.entrySet()) {
			keyList.add(obj.getKey());
			valueList.add(obj.getValue());
		}
		
		long merchant = keyList.get(0);
		double switchFee = valueList.get(0);
		Assert.assertEquals(3941400184L,merchant);
		Assert.assertEquals(0.09, switchFee,0);
		
	}
}
