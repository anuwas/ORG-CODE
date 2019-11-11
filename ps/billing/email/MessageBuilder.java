package com.mes.ps.billing.email;

/**
 * Mail Builder Class
 */
public abstract class MessageBuilder { 
  protected MailMessage message = new MailMessage();
  protected Environments env;
  protected MessageBody content;
  
  public void setMessageContent(MessageBody content) {
    this.content = content;
  }
  
  public abstract void buildSubject();
  
  public abstract void buildRecipients();
  
  public abstract void buildBody();
  
  public abstract MailMessage getMessage();
}
