package edu.miu.cs544.team6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs544.team6.domain.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{

}
