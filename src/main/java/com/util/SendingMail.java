/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Multipart;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.lang.String;

/**
 *
 * @author computer1
 */

public class SendingMail {

    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static final String SMTP_PORT = "465";
    private static final Log log = LogFactory.getLog(TrainingUtil.class);

    public void sendSSLMessage(List recipients, String subject,
            String messageContent, String from, String status, List name)
            throws MessagingException {
        boolean debug = false;
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    String username = "orbitwebsol@gmail.com";
                    String password = "sanjoykban";

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                username, password);
                    }
                });

        session.setDebug(debug);

        try {

            int i = 0;
            for (Iterator it = recipients.iterator(); it.hasNext();) {
                Message message = new MimeMessage(session);
                InternetAddress addressFrom = new InternetAddress(from);
                message.setFrom(addressFrom);
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress((String) it.next()));
                // Setting the Subject and Content Type
                message.setSubject(subject);
                message.setSentDate(new Date());

                // Create a message part to represent the body text
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setContent(messageContent, "text/html");

                // use a MimeMultipart as we need to handle the file attachments
                message.setText(createmessage(status, name.get(i).toString()));
                Transport.send(message);
                i++;
                log.info("Sent Mail");
            }










        } catch (MessagingException mex) {
            // Prints all nested (chained) exceptions as well
            mex.printStackTrace();
        }
    }

    public String createmessage(String status, String name) {
        if (status.equals("accepted")) {

            return ("hi" + name + " u r selected");
        } else if (status.equals("rejected")) {
            return ("hi" + name + " this is is a regret mail to u that u r not selected");
        } else {
            return ("hi" + name + "u r in queue....");
        }
    }
}
