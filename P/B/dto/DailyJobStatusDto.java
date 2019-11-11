package com.mes.ps.billing.dto;

import java.util.Date;

/**
 * DailyJobStatusDto Bean
 */
public class DailyJobStatusDto {
  private Long jobId;
  private Date jobStartTime;
  private JobType jobType;
  private Date paramBeginDate;
  private Date paramEndDate;
  private JobStatus jobStatus;
  
  public Long getJobId() {
    return jobId;
  }

  public void setJobId(Long jobId) {
    this.jobId = jobId;
  }

  public Date getJobStartTime() {
    return jobStartTime;
  }

  public void setJobStartTime(Date jobStartTime) {
    this.jobStartTime = jobStartTime;
  }

  public enum JobType {
    FETCH_TXN_DETAIL, 
    FETCH_BILLING_FEES;
  }

  public enum JobStatus {
    STARTED, FAILED, COMPLETED, COMP_ERROR;
  }

  public JobType getJobType() {
    return jobType;
  }

  public void setJobType(JobType jobType) {
    this.jobType = jobType;
  }

  public Date getParamBeginDate() {
    return paramBeginDate;
  }

  public void setParamBeginDate(Date paramBeginDate) {
    this.paramBeginDate = paramBeginDate;
  }

  public Date getParamEndDate() {
    return paramEndDate;
  }

  public void setParamEndDate(Date paramEndDate) {
    this.paramEndDate = paramEndDate;
  }

  public JobStatus getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(JobStatus jobStatus) {
    this.jobStatus = jobStatus;
  }

  @Override
  public String toString() {
    return "BillingJobDto [jobId=" + jobId + ", jobStartTime=" + jobStartTime + ", jobType=" + jobType
        + ", paramBeginDate=" + paramBeginDate + ", paramEndDate=" + paramEndDate
        + ", jobStatus=" + jobStatus + "]";
  }
}
