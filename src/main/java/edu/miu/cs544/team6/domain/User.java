package edu.miu.cs544.team6.domain;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Users_Tm")
public class User {

	@Id
	@GeneratedValue
	private int id;

	private String firstName;
	private String lastName;
	private String email;
	private String gender;

	@OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value="user")
	private List<Reservation> reservationList;

	@OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
	@JsonProperty("appointment")
	@JsonIgnoreProperties(value="user")
	private List<Appointment> appointmentList;

	@Enumerated(EnumType.STRING)
	private UserRoleE userRole;

	public UserRoleE getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleE userRole) {
		this.userRole = userRole;
	}

	public User(String firstName, String lastName, String email, String gender, UserRoleE role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.userRole = role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender
				+ ", reservationList=" + reservationList + ", appointmentList=" + appointmentList + ", userRole="
				+ userRole + "]";
	}

}
