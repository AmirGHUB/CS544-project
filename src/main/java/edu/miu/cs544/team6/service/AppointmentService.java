package edu.miu.cs544.team6.service;

import edu.miu.cs544.team6.domain.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> findAll();
}
