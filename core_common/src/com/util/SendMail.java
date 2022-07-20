package com.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static boolean send(String email, String msg, String subject, String host, String user, String pass, int port) throws MessagingException {
		try {
			if (email != null && !email.equals("")) {

				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", port);
				props.put("mail.smtp.user", user);
				props.put("mail.smtp.auth", pass);
				props.setProperty("mail.smtp.ssl.trust", host);

				Session ss = Session.getDefaultInstance(props, null);

				MimeMessage message = new MimeMessage(ss);
				message.setContent(msg, "text/html;charset=UTF-8");
				message.setSubject(subject, "UTF-8");

				// One mail
				Address address = new InternetAddress(email);
				message.setFrom(address);
				message.addRecipient(Message.RecipientType.TO, address);

				Transport transport = ss.getTransport("smtp");
				transport.connect(host, port, user, pass);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
