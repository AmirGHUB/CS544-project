package edu.miu.cs544.team6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.team6.domain.Appointment;
import edu.miu.cs544.team6.domain.User;
import edu.miu.cs544.team6.repository.AppointmentRepository;
import edu.miu.cs544.team6.repository.UserRepository;


@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private UserRepository userRepository;

	public void saveAppointment(Appointment appointment) {
		
		Optional<User> user =  userRepository.findById(appointment.getUserId());
		appointment.setProvider(user.get());		
		appointmentRepository.save(appointment);
	
	
	}

	public Appointment updateAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	public List<Appointment> getAll(){
		return appointmentRepository.findAll();
	}

	public void deleteAppointment(int appointmentId) {
		Optional<Appointment> appointment= appointmentRepository.findById(appointmentId);
		if (appointment ==null) return;
		appointmentRepository.deleteById(appointmentId);

	}

	public Appointment findById(int appointmentId) {
		Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
		return appointment.isPresent() ? appointment.get(): null;
	}
}
