package edu.miu.cs544.team6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.team6.domain.Appointment;
import edu.miu.cs544.team6.domain.Reservation;
import edu.miu.cs544.team6.domain.ReservationStatus;
import edu.miu.cs544.team6.repository.AppointmentRepository;
import edu.miu.cs544.team6.repository.ReservationRepository;
import edu.miu.cs544.team6.repository.UserRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	Notification notif;

	@Autowired
	AppointmentRepository appointmentRepository;

	public void save(Reservation reservation) {

		Optional<edu.miu.cs544.team6.domain.User> user = userRepository.findById(reservation.getUserId());

		reservation.setConsumer(user.get());

		Optional<Appointment> appointment = appointmentRepository.findById(reservation.getAppointmentId());

		reservation.setAppointment(appointment.get());

		reservationRepository.save(reservation);
	}

	public List<Reservation> findAll() {

		return reservationRepository.findAll();
	}

	public Reservation findById(int reservationId) {
		Optional<Reservation> reservation = reservationRepository.findById(reservationId);
		return reservation.isPresent() ? reservation.get() : null;
	}

	public Reservation update(Reservation reservation) {

		Optional<Appointment> appointment = appointmentRepository.findById(reservation.getAppointmentId());

		reservation.setAppointment(appointment.get());

		Optional<edu.miu.cs544.team6.domain.User> user = userRepository.findById(reservation.getUserId());
		reservation.setConsumer(user.get());

		if (reservation.getStatus().equals(ReservationStatus.ACCEPTED)
				|| reservation.getStatus().equals(ReservationStatus.DECLINED)) {
			notif.insertNotification(reservation);
		}

		return reservationRepository.save(reservation);

	}

	public void delete(int ReservationId) {
		Reservation oldReservation = findById(ReservationId);
		if (oldReservation == null) {
			return;
		}
		reservationRepository.deleteById(ReservationId);
	}

}
