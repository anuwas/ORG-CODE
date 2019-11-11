package com.mes.lcr.billing.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/lcr/api/v1")
public interface AcculynkBillingController {

	@RequestMapping(value = "/testapi", produces = {MediaType.TEXT_HTML_VALUE}, method = RequestMethod.GET)
	public String testApi();

	@RequestMapping(value = "/daily/billing", produces = {MediaType.TEXT_HTML_VALUE}, method = RequestMethod.POST)
	public String dailyBilling(@RequestParam(value = "loadfileDate", required = true) String loadfileDate);

	@RequestMapping(value = "/clear/dailybilling", produces = {MediaType.TEXT_HTML_VALUE}, method = RequestMethod.POST)
	public String clearDailyBillingDataByDate(@RequestParam(value = "loadfileDate", required = true) String loadfileDate);

	@RequestMapping(value = "/merchfunding", produces = {MediaType.TEXT_HTML_VALUE}, method = RequestMethod.POST)
	public String acculynkMerchantFunding();

}
