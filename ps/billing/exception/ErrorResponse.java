package com.mes.ps.billing.exception;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * ErrorResponse Bean
 */
@XmlRootElement
public class ErrorResponse {
  private int code;
  private String message;

  public int getCode() {
    return code;
  }

  public void setCode(int errorCode) {
    this.code = errorCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
