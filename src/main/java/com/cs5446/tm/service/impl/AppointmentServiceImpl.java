package com.cs5446.tm.service.impl;

import com.cs5446.tm.model.Appointment;
import com.cs5446.tm.repository.AppointmentRepository;
import com.cs5446.tm.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }
}
