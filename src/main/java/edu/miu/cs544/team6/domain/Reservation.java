package edu.miu.cs544.team6.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date reservationDate;

	@Enumerated(EnumType.STRING)
	private ReservationStatus status;

	@ManyToOne(cascade = CascadeType.ALL)
	private User consumer;

	@ManyToOne(cascade = CascadeType.ALL)
	private Appointment appointment;

	@Transient
	private Integer userId;

	@Transient
	private Integer appointmentId;

	public Reservation(Date reservationDate, Integer userId, Integer appointmentId) {
		this.reservationDate = reservationDate;
		this.userId = userId;
		this.appointmentId = appointmentId;
		
		this.status = ReservationStatus.PENDING;
	}

	public Reservation() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", reservationDate=" + reservationDate + ", status=" + status + "]";
	}

}
