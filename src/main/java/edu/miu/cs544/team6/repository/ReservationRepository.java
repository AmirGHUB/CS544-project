package edu.miu.cs544.team6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.miu.cs544.team6.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	@Query(value = "SELECT * FROM RESERVATION r WHERE r.status = 'ACCEPTED' AND IS_REMINDER_SENT IS NULL", nativeQuery = true)
	List<Reservation> findNewAcceptedReservations();
  
}
