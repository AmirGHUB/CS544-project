package edu.miu.cs544.team6.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.team6.domain.Appointment;
import edu.miu.cs544.team6.service.AppointmentService;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping
	public void save(@RequestBody Appointment appointment) {
		appointmentService.saveAppointment(appointment);
	}
		
	@PutMapping("/{appointmentId}")
	public Appointment update(@PathVariable int appointmentId, @RequestBody Appointment appointment) {
		Appointment a = appointmentService.findById(appointmentId);
		if (a == null) return null;
		appointment.setId(appointmentId);
		return appointmentService.updateAppointment(appointment);
	}

	
	@GetMapping
	public List<Appointment> getAll(){
		return appointmentService.getAll();
	}
	
	   @GetMapping("/{appointmentId}")
	    public Appointment getReservationById(@PathVariable int appointmentId) {
	    	return appointmentService.findById(appointmentId);
	    }
	
	@DeleteMapping("/{appointmentId}")
	public void delete(@PathVariable int appointmentId) {
		appointmentService.deleteAppointment(appointmentId);
		
	}
}
