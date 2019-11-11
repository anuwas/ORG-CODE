package com.mes.ps.billing.email;

/**
 * Mail Message Content Class
 */
public class MessageBody {
  private String message;

  public MessageBody() {
  }

  public MessageBody(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
