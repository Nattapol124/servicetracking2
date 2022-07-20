package com.util;

import javax.mail.MessagingException;

public class SendMailThread implements Runnable {

	private String host;
	private String user;
	private String pass;
	private int port;
	private String email;
	private String msg;
	private String subject;

	public SendMailThread(String email, String msg, String subject,
			String host, String user, String pass, int port) {
		this.host = host;
		this.user = user;
		this.pass = pass;
		this.port = port;
		this.email = email;
		this.msg = msg;
		this.subject = subject;
	}

	@Override
	public void run() {
		try {
			SendMail.send(email, msg, subject, host, user, pass, port);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
