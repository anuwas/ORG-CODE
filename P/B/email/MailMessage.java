package com.mes.ps.billing.email;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Mail Message Class
 */
public class MailMessage {
  private Recipients recipients;
  private MessageBody body;
  private String subject;
  private String from;

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Recipients getRecipients() {
    return recipients;
  }

  public void setRecipients(Recipients recipients) {
    this.recipients = recipients;
  }

  public MessageBody getBody() {
    return body;
  }

  public void setBody(MessageBody body) {
    this.body = body;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }
  
  public String getCurrentDateTime() {
    String curDateTime = "";
    try {
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
      curDateTime = df.format(Calendar.getInstance().getTime());
    } catch (Exception e) {
      // do nothing
    }
    return curDateTime;
  }

  class Recipients {
    private java.util.Deque<String> recipients = new LinkedList<>();

    public Recipients(String recipients) {
      StringTokenizer tokenizer = new StringTokenizer(recipients, ";");
      while(tokenizer.hasMoreTokens()) {
        addRecipient(tokenizer.nextToken());
      }
    }

    public void addRecipient(String recipient) {
      recipients.add(recipient);
    }

    public String getRecipient() {
      return recipients.poll();
    }
  }

  class MessageBody {
    private StringBuilder body = new StringBuilder();

    public void addLine(String text) {
      body.append("\n" + text);
    }

    public void append(String text) {
      body.append(text);
    }

    public String getText() {
      return body.toString();
    }
  }
}