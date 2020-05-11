package edu.miu.cs544.team6.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Appointment {

	@Id
	@GeneratedValue
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date appointmentDate;
	
	private String location;
	
	@ManyToOne
	private User provider;
	
	@OneToMany (mappedBy = "appointment")
	private List<Reservation> reservationList;

	public Appointment(Date appointmentDate, String location) {
		this.appointmentDate = appointmentDate;
		this.location = location;
		this.reservationList = new ArrayList<>();
	}

	public Appointment() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getProvider() {
		return provider;
	}

	public void setProvider(User provider) {
		this.provider = provider;
	}

	public List<Reservation> getReservationList() {
		return Collections.unmodifiableList(reservationList);
	}

	public void addReservation(Reservation reservation) {
		reservation.setAppointment(this);
		reservationList.add(reservation);
	}

	public void removeReservation(Reservation reservation) {
		reservation.setAppointment(null);
		reservationList.remove(reservation);
	}

	
}
