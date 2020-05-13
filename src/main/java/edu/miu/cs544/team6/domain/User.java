package edu.miu.cs544.team6.domain;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {

	@Id
	@GeneratedValue
	private int id;


	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	


	@OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL)
	private List<Reservation> reservationList;

	@OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
	private List<Appointment> appointmentList;

	@Enumerated(EnumType.STRING)
	private UserRoleE userRole;

	public UserRoleE getUserRole() {
		return userRole;
	}


	public void setUserRole(UserRoleE userRole) {
		this.userRole = userRole;
	}


	public User(String firstName, String lastName, String email, String gender, UserRoleE role ) {
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
		return Collections.unmodifiableList(reservationList);
	}

	public void addReservation(Reservation reservation) {
		reservation.setConsumer(this);
		;
		reservationList.add(reservation);
	}

	public void removeReservation(Reservation reservation) {
		reservation.setConsumer(null);
		reservationList.remove(reservation);
	}

	public List<Appointment> getAppointmentList() {
		return Collections.unmodifiableList(appointmentList);
	}

	public void addAppointment(Appointment appointment) {
		appointment.setProvider(this);
		appointmentList.add(appointment);
	}

	public void removeAppointment(Appointment appointment) {
		appointment.setProvider(null);
		appointmentList.remove(appointment);
	}

}