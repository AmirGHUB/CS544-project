package edu.miu.cs544.team6.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.miu.cs544.team6.domain.ReservationStatus;


public class ReservationDTO {

	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date reservationDate;

	@Enumerated(EnumType.STRING)
	private ReservationStatus status;

	@ManyToOne 
	private UserDTO consumer;

	@ManyToOne
	private AppointmentDTO appointmentDTO;

	public ReservationDTO(Date reservationDate, ReservationStatus status) {
		this.reservationDate = reservationDate;
		this.status = status;
	}

	public ReservationDTO() {}

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

	public UserDTO getConsumer() {
		return consumer;
	}

	public void setConsumer(UserDTO consumer) {
		this.consumer = consumer;
	}

	public AppointmentDTO getAppointmentDTO() {
		return appointmentDTO;
	}

	public void setAppointmentDTO(AppointmentDTO appointmentDTO) {
		this.appointmentDTO = appointmentDTO;
	}




}
