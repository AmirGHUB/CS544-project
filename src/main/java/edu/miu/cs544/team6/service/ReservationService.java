package edu.miu.cs544.team6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.team6.domain.Reservation;
import edu.miu.cs544.team6.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	public void save(Reservation reservation) {
		
		reservationRepository.save(reservation);
	}
	
	public List<Reservation> findAll(){
		return reservationRepository.findAll();
	}
	
	public Reservation findById(int reservationId) {
		Optional<Reservation> reservation = reservationRepository.findById(reservationId);
		return reservation.isPresent() ? reservation.get(): null; 
	}
	
	public Reservation update(int reservationId) {
		Reservation oldReservation = findById(reservationId);
    	if(oldReservation == null){
    		return null;
    	}
    	return reservationRepository.save(oldReservation);
	}
	
	public void delete(int ReservationId) {
		Reservation oldReservation = findById(ReservationId);
    	if(oldReservation == null){
    		return;
    	}
    	reservationRepository.deleteById(ReservationId);
	}

}
