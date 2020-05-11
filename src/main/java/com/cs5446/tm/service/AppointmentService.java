package com.cs5446.tm.service;

import com.cs5446.tm.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> findAll();
}
