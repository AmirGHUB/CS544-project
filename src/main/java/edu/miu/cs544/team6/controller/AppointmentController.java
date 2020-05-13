package edu.miu.cs544.team6.controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.team6.domain.Appointment;
import edu.miu.cs544.team6.domain.Reservation;
import edu.miu.cs544.team6.dto.AppointmentDTO;
import edu.miu.cs544.team6.dto.ReservationDTO;
import edu.miu.cs544.team6.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@PostMapping()
    public void createAppointment(@RequestBody Appointment appointment) {
		appointmentService.save(appointment);
    }
    @GetMapping()
    public List<AppointmentDTO> getAppointment(){
    	return appointmentService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @GetMapping("/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable int appointmentId) {
    	return appointmentService.findById(appointmentId);
    }
    
    @PostMapping("/{appointmentId}")
    public Appointment updateById(@PathVariable int appointmentId) {
    	return appointmentService.update(appointmentId);
    }
    
    @DeleteMapping("/{appointmentId}")
    public void deleteAppointment(@PathVariable int appointmentId) {
    	appointmentService.delete(appointmentId);
    }
	
    /** from system to user -- Map to AppointmentDTO **/
    private AppointmentDTO convertToDTO(Appointment appointment) {
    	AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);  
        return appointmentDTO;
    }
    
}
