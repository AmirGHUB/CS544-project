package edu.miu.cs544.team6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs544.team6.domain.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment , Integer> {
	
}
