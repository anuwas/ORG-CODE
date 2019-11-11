package com.mes.ps.billing.email;

/**
 * Success message builder class
 */
public class SuccessMessageBuilder extends MessageBuilder {
  
  public SuccessMessageBuilder(Environments env) {
    this.env = env;
  }

  @Override
  public void buildSubject() {
    message.setSubject("ProfitStar Data Load Successful");
  }

  @Override
  public void buildRecipients() {
    MailMessage.Recipients recipients =  message.new Recipients(env.get("mail.success.recipients"));
    message.setRecipients(recipients);
  }

  @Override
  public void buildBody() {
    MailMessage.MessageBody messageBody = message.new MessageBody();
    messageBody.append("Successfully loaded data from ProfitStar into mbs_daily_summary table at ["+ message
        .getCurrentDateTime() + "]");
    message.setBody(messageBody);
  }

  @Override
  public MailMessage getMessage() {
    return message;
  }
}
