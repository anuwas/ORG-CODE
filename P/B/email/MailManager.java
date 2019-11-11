package com.mes.ps.billing.email;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mail Manager Class To Send Mail
 */

@Component
public class MailManager {
  private static Logger logger = LoggerFactory.getLogger(MailManager.class);
  @Autowired
  private Environments env;
  
  /**
   * Build message based on MessageType
   * @param content is MessageBody
   * @param messageType is MessageType
   */
  public void buildAndSendMessage(MessageBody content, MessageType messageType) {
    //validate property of recipients address
    if(!validateProperties()) {
      return;
    }
    
    MessageBuilder messageBuilder = getBuilder(messageType);
    messageBuilder.setMessageContent(content);
    messageBuilder.buildSubject();
    messageBuilder.buildRecipients();
    messageBuilder.buildBody();
    sendMail(messageBuilder.getMessage());
  }

  public enum MessageType {
    SUCCESS, FAILED
  }
  
  /**
   * Get MessageBuilder based on type
   * @param type is MessageType
   */
  private MessageBuilder getBuilder(MessageType type) {
    if (type == MessageType.SUCCESS) {
      return new SuccessMessageBuilder(env);
    } else {
      return new ErrorMessageBuilder(env);
    }
  }

  /**
   * Validate required property
   */
  private boolean validateProperties() {
    if (env == null || StringUtils.isBlank(env.get("mail.success.recipients"))
        || StringUtils.isBlank(env.get("mail.smtp.host"))) {
      logger.error("Required mail send property missing, no email will be sent.");
      return false;
    } else {
      return true;
    }
  }

  /**
   * Send Mail
   * @param message is EmailMessage
   */
  private void sendMail(MailMessage message) {
    try {
      if (!env.getBoolean("mail.enabled")) {
        logger.info("Email is not enabled");
        return;
      }

      SMTPMail email = new SMTPMail(env.get("mail.smtp.host"), 25);
      String recipient;
      while ((recipient = message.getRecipients().getRecipient()) != null) {
        email.addRecipient(recipient);
      }

      email.setSubject(message.getSubject());
      email.setText(message.getBody().getText());
      email.setFrom(env.get("mail.fromAddress"));
      email.send();
    } catch (Exception e) {
      logger.error("Failed to send email", e);
    }
  }


}
