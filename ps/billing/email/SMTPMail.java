package com.mes.ps.billing.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.Properties;

/**
 * This class used to send mail
 */
public class SMTPMail {
    private static Logger log = LoggerFactory.getLogger(SMTPMail.class);

    private Session session;
    private MimeMessage message;
    private Multipart body;
    private MimeBodyPart textPart;


    /**
     * Initialization method for Mail functionality
     * @param smtpHost
     * @param smtpPort
     * @throws javax.mail.MessagingException
     */
    public SMTPMail(String smtpHost, int smtpPort) throws javax.mail.MessagingException {
        initialize(smtpHost, smtpPort);
    }

    /**
     * Private initialization method for Mail functionality
     * @param smtpHost
     * @param smtpPort
     * @throws javax.mail.MessagingException
     */
    private void initialize(String smtpHost, int smtpPort) throws javax.mail.MessagingException {
        log.debug("SMTPEmail initializing with SMTP host: " + smtpHost + ":" + smtpPort);

        // configure smtp host and port
        Properties props = System.getProperties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
        session = Session.getInstance(props, null);
        //session.setDebug(true);

        // create message, multipart body of message
        // and the text part of the message
        message = new MimeMessage(session);
        body = new MimeMultipart();
        textPart = new MimeBodyPart();
        body.addBodyPart(textPart);
        message.setContent(body);
    }


    /**
     * Sender configuration method for mail functionality
     * @param address
     * @throws javax.mail.MessagingException
     */
    public void setFrom(String address) throws javax.mail.MessagingException {
        if (address != null && !address.equals("")) {
            message.setFrom(new InternetAddress(address));
        }
    }

    /**
     * Recipient configuration method for mail functionality
     * @param type
     * @param address
     * @throws javax.mail.MessagingException
     */
    public void addRecipient(RecipientType type, String address) throws javax.mail.MessagingException {
        if (address != null && !address.equals("")) {
            message.addRecipient(type, new InternetAddress(address));
        }
    }

    /**
     * Recipient configuration method for mail functionality
     * @param address
     * @throws javax.mail.MessagingException
     */
    public void addRecipient(String address) throws javax.mail.MessagingException {
        addRecipient(RecipientType.TO, address);
    }

    /**
     * To Recipient configuration method for mail functionality
     * @param address
     * @throws javax.mail.MessagingException
     */
    public void addTORecipient(String address) throws javax.mail.MessagingException {
        addRecipient(RecipientType.TO, address);
    }

    /**
     * CC Recipient configuration method for mail functionality
     * @param address
     * @throws javax.mail.MessagingException
     */
    public void addCCRecipient(String address) throws javax.mail.MessagingException {
        addRecipient(RecipientType.CC, address);
    }

    /**
     * BCC Recipient configuration method for mail functionality
     * @param address
     * @throws javax.mail.MessagingException
     */
    public void addBCCRecipient(String address) throws javax.mail.MessagingException {
        addRecipient(RecipientType.BCC, address);
    }

    /**
     * Recipient configuration method for mail functionality
     * Support for delimited recipient strings
     * @param type
     * @param addresses
     * @throws javax.mail.MessagingException
     */
    public void addRecipients(RecipientType type, String addresses) throws javax.mail.MessagingException {
        message.addRecipients(type, addresses);
    }

    /**
     * Recipient configuration method for mail functionality
     * Support for delimited recipient strings
     * @param addresses
     * @throws javax.mail.MessagingException
     */
    public void addRecipients(String addresses) throws javax.mail.MessagingException {
        addRecipients(RecipientType.TO, addresses);
    }

    /**
     * To Recipient configuration method for mail functionality
     * Support for delimited recipient strings
     * @param addresses
     * @throws javax.mail.MessagingException
     */
    public void addTORecipients(String addresses) throws javax.mail.MessagingException {
        addRecipients(RecipientType.TO, addresses);
    }

    /**
     * CC Recipient configuration method for mail functionality
     * Support for delimited recipient strings
     * @param addresses
     * @throws javax.mail.MessagingException
     */
    public void addCCRecipients(String addresses) throws javax.mail.MessagingException {
        addRecipients(RecipientType.CC, addresses);
    }

    /**
     * BCC Recipient configuration method for mail functionality
     * Support for delimited recipient strings
     * @param addresses
     * @throws javax.mail.MessagingException
     */
    public void addBCCRecipients(String addresses) throws javax.mail.MessagingException {
        addRecipients(RecipientType.BCC, addresses);
    }

    /**
     * Subject setter method for mail functionality
     * @param subject
     * @throws javax.mail.MessagingException
     */
    public void setSubject(String subject) throws javax.mail.MessagingException {
        if (subject != null) {
            message.setSubject(subject);
        }
    }

    /**
     * Text setter method for mail functionality
     * @param text
     * @throws javax.mail.MessagingException
     */
    public void setText(String text) throws javax.mail.MessagingException {
        if (text != null) {
            textPart.setText(text);
        }
    }	

    /**
     * Attachment setter method for mail functionality
     * @param filename
     * @param fileData
     * @throws javax.mail.MessagingException
     */
    public void addStringAsTextFile(String filename, String fileData) throws javax.mail.MessagingException {
        // create a new body part for the file attachment
        MimeBodyPart filePart = new MimeBodyPart();

        // add the file data string to the body part as a text file
        filePart.setText(fileData);

        // set file name
        filePart.setFileName(filename);

        // add the new body part to the main body
        body.addBodyPart(filePart);
    }

    /**
     * Attachment setter method for mail functionality
     * @param filename
     * @throws javax.mail.MessagingException
     */
    public void addFile(String filename) throws javax.mail.MessagingException {
        // create a new body part for the file attachment
        MimeBodyPart filePart = new MimeBodyPart();

        // set the file as the contents of the file body part
        DataSource source = new FileDataSource(filename);
        filePart.setDataHandler(new DataHandler(source));

        // set file name less any path information
        filePart.setFileName(source.getName());

        // add the new body part to the main body
        body.addBodyPart(filePart);
    }

    /**
     * A DataSource implementation for byte arrays, allows byte arrays
     * to be added as file attachments to the email.
     */
    public class ByteArrayDataSource implements DataSource {
        private byte[] data;
        private String mimeType = "application/octet-stream";

        public ByteArrayDataSource(byte[] data) {
            this.data = data;
        }

        public ByteArrayDataSource(byte[] data, String mimeType) {
            this.data = data;
            this.mimeType = mimeType;
        }

        public String getContentType() {
            return mimeType;
        }

        public String getName() {
            return "Anonymous ByteArrayDataSource";
        }

        public InputStream getInputStream() {
            return new ByteArrayInputStream(data);
        }

        public OutputStream getOutputStream() throws IOException {
            throw new IOException("Output not supported");
        }
    }

    /**
     * Attachment setter method for mail functionality
     * @param filename
     * @param data
     * @throws Exception
     */
    public void addByteArrayAsFile(String filename, byte[] data) throws Exception {
        // create a new body part for the file attachment
        MimeBodyPart filePart = new MimeBodyPart();

        // set the file as the contents of the file body part
        DataSource source = new ByteArrayDataSource(data);
        filePart.setDataHandler(new DataHandler(source));

        // set file name less any path information
        filePart.setFileName((new File(filename)).getName());

        // add the new body part to the main body
        body.addBodyPart(filePart);
    }

    /**
     * Send method for mail functionality
     * @throws javax.mail.MessagingException
     */
    public void send() throws javax.mail.MessagingException {
        Transport.send(message);
    }
}
