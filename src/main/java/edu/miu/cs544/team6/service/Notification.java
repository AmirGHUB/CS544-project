package edu.miu.cs544.team6.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import edu.miu.cs544.team6.domain.EmailNotification;
import edu.miu.cs544.team6.domain.Reservation;
import edu.miu.cs544.team6.enums.ENotificationStatus;
import edu.miu.cs544.team6.repository.NotificationRepository;

@Service
public class Notification {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private NotificationRepository repository;

	@Scheduled(fixedDelayString = "${sync-job.delay.milliseconds.fixed}", initialDelayString = "${sync-job.delay.milliseconds.initial}")
	public void schSendEmail() {

		List<EmailNotification> lstEmail = repository.findByStatus(ENotificationStatus.NEW);

		for (EmailNotification email : lstEmail) {
			System.out.println(email.toString());
			sendMail(null);
		}

		System.out.println("working schedule: " + LocalDateTime.now());
	}

	@Scheduled(fixedDelayString = "${sync-job.delay.milliseconds.fixed}", initialDelayString = "${sync-job.delay.milliseconds.initial}")
	public void schReminder() {

		List<EmailNotification> lstEmail = repository.findByStatus(ENotificationStatus.NEW);

		for (EmailNotification email : lstEmail) {
			System.out.println(email.toString());
			sendMail(null);
		}

		System.out.println("working schedule: " + LocalDateTime.now());
	}

	@Async
	public void sendMail(EmailNotification email) {
		System.out.println("sending email");
		SimpleMailMessage message = new SimpleMailMessage();
		try {

			message.setFrom("TM Appointment System");
			message.setTo(email.getRecipientEmail());
			message.setSubject(email.getSubject());
			message.setText(email.getContent());
			mailSender.send(message);

			email.setStatus(ENotificationStatus.SUCCEED);
			updateNotification(email);

		} catch (MailException me) {
			System.out.println("email exception: " + me);

			email.setStatus(ENotificationStatus.FAILED);
			updateNotification(email);
		}
	}

	@Async
	public void insertNotification(Reservation reservation) {
		EmailNotification emailNotif = new EmailNotification();
		emailNotif.setReservation(reservation);
		emailNotif.setAppointmentDatetime(reservation.getAppointment().getAppointmentDate());
		emailNotif.setContent(String.format("Dear %s, Your reservation number %s is %s",
				reservation.getConsumer().getFirstName(), reservation.getId(), reservation.getStatus()));
		emailNotif.setCreatedDatetime(new Date());
		emailNotif.setRecipientEmail(reservation.getConsumer().getEmail());
		emailNotif.setSentDatetime(null);
		emailNotif.setStatus(ENotificationStatus.NEW);
		emailNotif.setSubject(String.format("Decision about reservation id: %s", reservation.getId()));
		emailNotif.setReservation(reservation);
		repository.save(emailNotif);
	}

	public void updateNotification(EmailNotification emailNotif) {
		repository.save(emailNotif);
	}
}
