package com.mes.ps.billing.dto;

import java.util.Date;

/**
 * MonthlyBillingProcess Bean
 */
public class MonthlyBillingProcess {
  private long recId;
  private int processType;
  private int processSequence;
  private Date processBeginDate;
  private Date processEndDate;
  private String processElapsed;
  private String loadFileName;

  public long getRecId() {
    return recId;
  }

  public void setRecId(long recId) {
    this.recId = recId;
  }

  public int getProcessType() {
    return processType;
  }

  public void setProcessType(int processType) {
    this.processType = processType;
  }

  public int getProcessSequence() {
    return processSequence;
  }

  public void setProcessSequence(int processSequence) {
    this.processSequence = processSequence;
  }

  public Date getProcessBeginDate() {
    return processBeginDate;
  }

  public void setProcessBeginDate(Date processBeginDate) {
    this.processBeginDate = processBeginDate;
  }

  public Date getProcessEndDate() {
    return processEndDate;
  }

  public void setProcessEndDate(Date processEndDate) {
    this.processEndDate = processEndDate;
  }

  public String getProcessElapsed() {
    return processElapsed;
  }

  public void setProcessElapsed(String processElapsed) {
    this.processElapsed = processElapsed;
  }

  public String getLoadFileName() {
    return loadFileName;
  }

  public void setLoadFileName(String loadFileName) {
    this.loadFileName = loadFileName;
  }
}
