package edu.miu.cs544.team6.service.impl;

import edu.miu.cs544.team6.domain.Reservation;
import edu.miu.cs544.team6.repository.ReservationRepository;
import edu.miu.cs544.team6.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
