package edu.miu.cs544.team6.service.impl;

import edu.miu.cs544.team6.domain.Appointment;
import edu.miu.cs544.team6.repository.AppointmentRepository;
import edu.miu.cs544.team6.service.AppointmentService;
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
