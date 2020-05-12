package edu.miu.cs544.team6.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import edu.miu.cs544.team6.domain.EmailNotification;
import edu.miu.cs544.team6.repository.NotificationRepository;

@Service
public class Notification {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private NotificationRepository repository;

	@Scheduled(fixedDelayString = "${sync-job.delay.milliseconds.fixed}", initialDelayString = "${sync-job.delay.milliseconds.initial}")
	public void checkNotification() {

		List<EmailNotification> lstEmail = repository.findByStatus("PENDING");

		for (EmailNotification email : lstEmail) {
			System.out.println(email.toString());
		}

		sendMail(null);

		System.out.println("working schedule: " + LocalDateTime.now());
	}

	@Async
	public void sendMail(EmailNotification email) {
		System.out.println("sending email");
		SimpleMailMessage message = new SimpleMailMessage();
		try {

			message.setFrom("fromMail");
			message.setTo("ochiroo13@gmail.com");
			message.setSubject("Subje");
			message.setText("this is content");
			mailSender.send(message);
		} catch (MailException me) {
			System.out.println("email exception: " + me);
		}
	}
}
