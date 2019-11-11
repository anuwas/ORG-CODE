package com.mes.lcr.billing.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mes.partner")
public class PartnerConfig {
	
	private Map<Long,Double> switchfeeconfig;
	
	PartnerConfig(){
		this.switchfeeconfig = new HashMap<>();
	}
	
	public Map<Long,Double> getSwitchfeeconfig() {
		return switchfeeconfig;
	}

}
