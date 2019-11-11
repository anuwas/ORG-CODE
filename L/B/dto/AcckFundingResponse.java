package com.mes.lcr.billing.dto;

import com.mes.lcr.billing.dao.DailyDetailFileDTF;

public class AcckFundingResponse {

  private int count;
  private DailyDetailFileDTF detailFileDTF;

  public int getCount() {
    return this.count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public DailyDetailFileDTF getDetailFileDT() {
    return this.detailFileDTF;
  }

  public void setDetailFileDTF(DailyDetailFileDTF detailFileDT) {
    this.detailFileDTF = detailFileDTF;
  }

}
