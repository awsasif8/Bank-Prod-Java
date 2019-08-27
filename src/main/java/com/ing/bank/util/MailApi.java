package com.ing.bank.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Component;

@Component
public class MailApi {

	private JavaMailSender mailSender;
	
	@Autowired
	public MailApi(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String mailId, Integer orderGenId) {

		String message2 = "Your order is succesfully generated with orderId  ";

		String orderGenId1 = orderGenId.toString();

		String message1 = message2.concat(orderGenId1);

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("sai555977charan@gmail.com");
		mail.setTo(mailId);
		mail.setText(message1);
		mail.setSubject("Mail From Spring Boot");

		mailSender.send(mail);

	}
}
