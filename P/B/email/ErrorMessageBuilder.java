package com.mes.ps.billing.email;

/**
 * Error mail message
 */
public class ErrorMessageBuilder extends MessageBuilder {

  public ErrorMessageBuilder(Environments env) {
    this.env = env;
  }

  @Override
  public void buildSubject() {
    message.setSubject("ProfitStar Data Load Failed");
  }

  @Override
  public void buildRecipients() {
    MailMessage.Recipients recipients = message.new Recipients(env.get("mail.failed.recipients"));
    message.setRecipients(recipients);
  }

  @Override
  public void buildBody() {
    MailMessage.MessageBody messageBody = message.new MessageBody();
    messageBody.append("Failed to load ProfitStar data due to some error at [" + message.getCurrentDateTime() + "]");

    message.setBody(messageBody);
  }

  @Override
  public MailMessage getMessage() {
    return message;
  }
}
