package edu.miu.cs544.team6.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(value= {"provider","reservationList"})
public class Appointment {
	
	@Id
	@GeneratedValue
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date appointmentDate;
	
	private String location;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonProperty("provider")
	private User provider;
	
	@OneToMany (mappedBy = "appointment", cascade = CascadeType.ALL)
	@JsonProperty(value="reservationList")
	private List<Reservation> reservationList;
	
	
	Integer userId;

	public Appointment(Date appointmentDate, String location, Integer userId) {
		this.appointmentDate = appointmentDate;
		this.location = location;
		this.userId = userId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void addReservation(Reservation reservation) {
		reservation.setAppointment(this);
		reservationList.add(reservation);
	}

	public void removeReservation(Reservation reservation) {
		reservation.setAppointment(null);
		reservationList.remove(reservation);
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentDate=" + appointmentDate + ", location=" + location
				+ ", reservationList=" + reservationList + "]";
	}

	
}
