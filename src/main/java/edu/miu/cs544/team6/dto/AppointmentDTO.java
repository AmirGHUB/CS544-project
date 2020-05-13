package edu.miu.cs544.team6.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



public class AppointmentDTO {

	private int id;

	private Date appointmentDate;
	
	private String location;

	private UserDTO provider;

	private List<ReservationDTO> reservationList;

	public AppointmentDTO(Date appointmentDate, String location) {
		this.appointmentDate = appointmentDate;
		this.location = location;
		this.reservationList = new ArrayList<>();
	}

	public AppointmentDTO() {}

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

	public UserDTO getProvider() {
		return provider;
	}

	public void setProvider(UserDTO provider) {
		this.provider = provider;
	}

	public List<ReservationDTO> getReservationList() {
		return Collections.unmodifiableList(reservationList);
	}

	public void addReservation(ReservationDTO reservationDTO) {
		reservationDTO.setAppointmentDTO(this);
		reservationList.add(reservationDTO);
	}

	public void removeReservation(ReservationDTO reservationDTO) {
		reservationDTO.setAppointmentDTO(null);
		reservationList.remove(reservationDTO);
	}
}
