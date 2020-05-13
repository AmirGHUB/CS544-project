package edu.miu.cs544.team6.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class UserDTO {


	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;

	private List<ReservationDTO> reservationList;

	private List<AppointmentDTO> appointmentList;

	private List<UserRoleDTO> userRole;

	public UserDTO(String firstName, String lastName, String email, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;

		this.appointmentList = new ArrayList<>();
		this.reservationList = new ArrayList<>();
		this.userRole = new ArrayList<>();
	}

	public UserDTO() {
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

	public List<ReservationDTO> getReservationList() {
		return Collections.unmodifiableList(reservationList);
	}

	public void addReservationDTO(ReservationDTO reservation) {
		reservation.setConsumer(this);
		reservationList.add(reservation);
	}

	public void removeReservation(ReservationDTO reservation) {
		reservation.setConsumer(null);
		reservationList.remove(reservation);
	}

	public List<AppointmentDTO> getAppointmentList() {
		return Collections.unmodifiableList(appointmentList);
	}

	public void addAppointment(AppointmentDTO appointment) {
		appointment.setProvider(this);
		appointmentList.add(appointment);
	}

	public void removeAppointment(AppointmentDTO appointment) {
		appointment.setProvider(null);
		appointmentList.remove(appointment);
	}

	
	public List<UserRoleDTO> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRoleDTO> userRole) {
		this.userRole = userRole;
	}

}
