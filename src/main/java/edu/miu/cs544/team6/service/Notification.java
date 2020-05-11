package edu.miu.cs544.team6.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

//		repository.findAll();

		sendMail(null);

		System.out.println("working schedule: " + LocalDateTime.now());
	}

	public void sendMail(EmailNotification email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("fromMail");
		message.setTo("ochiroo13@gmail.com");
		message.setSubject("Subje");
		message.setText("this is content");
		mailSender.send(message);
	}
}
