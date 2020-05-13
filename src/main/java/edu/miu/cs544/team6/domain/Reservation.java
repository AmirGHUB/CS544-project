package edu.miu.cs544.team6.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date reservationDate;

	@Enumerated(EnumType.STRING)
	private ReservationStatus status;

	@ManyToOne
	private User consumer;

	@ManyToOne
	private Appointment appointment;

	@Column(name = "is_reminder_sent")
	private Integer isReminderSent;

	public Reservation(Date reservationDate, ReservationStatus status) {
		this.reservationDate = reservationDate;
		this.status = status;
	}

	public Reservation() {
		isReminderSent = 0;
	}

	public int getId() {
		return id;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	public User getConsumer() {
		return consumer;
	}

	public void setConsumer(User consumer) {
		this.consumer = consumer;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Integer getIsReminderSent() {
		return isReminderSent;
	}

	public void setIsReminderSent(Integer isReminderSent) {
		this.isReminderSent = isReminderSent;
	}

}
