package edu.miu.cs544.team6.controller;


import edu.miu.cs544.team6.domain.Appointment;
import edu.miu.cs544.team6.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments(){
        return appointmentService.findAll();
    }
}
