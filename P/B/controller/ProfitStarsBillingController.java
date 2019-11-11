package com.mes.ps.billing.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * APIs for manual invocation of billing services
 */
@RequestMapping("/achps/api/v1")
public interface ProfitStarsBillingController {

  /**
   * API for manual invocation of monthly billing service
   * @param monthYear
   * @return
   */
  @RequestMapping(value = "/monthly", produces = {
  MediaType.TEXT_HTML_VALUE }, method = RequestMethod.POST)
  public String executeMonthlyBillingJob(@RequestParam(value = "monthYear", required = false) String monthYear);

  /**
   * API for manual invocation of daily billing service
   * @param monthYear
   * @return
   */
  @RequestMapping(value = "/daily", produces = {
  MediaType.TEXT_HTML_VALUE }, method = RequestMethod.POST)
  public String executeDailyTransactionDetailJob(@RequestParam(value = "dayMonthYear", required = false) String monthYear);
}
