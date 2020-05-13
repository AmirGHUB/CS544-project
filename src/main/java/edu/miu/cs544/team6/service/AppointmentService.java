package edu.miu.cs544.team6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.team6.domain.Appointment;
import edu.miu.cs544.team6.repository.AppointmentRepository;


@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public void save(Appointment appointment) {
		
		appointmentRepository.save(appointment);
	}
	
	public List<Appointment> findAll(){
		return appointmentRepository.findAll();
	}
	
	public Appointment findById(int appoitnmentId) {
		Optional<Appointment> appointment = appointmentRepository.findById(appoitnmentId);
		return appointment.isPresent() ? appointment.get(): null; 
	}
	
	public Appointment update(int appointmentId) {
		Appointment existingAppointment = findById(appointmentId);
    	if(existingAppointment == null){
    		return null;
    	}
    	return appointmentRepository.save(existingAppointment);
	}
	
	public void delete(int appointmentId) {
		Appointment appointment = findById(appointmentId);
    	if(appointment == null){
    		return;
    	}
    	appointmentRepository.deleteById(appointmentId);
	}

}
