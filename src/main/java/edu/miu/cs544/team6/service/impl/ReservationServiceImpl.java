package com.cs5446.tm.service.impl;

import com.cs5446.tm.model.Reservation;
import com.cs5446.tm.repository.ReservationRepository;
import com.cs5446.tm.service.ReservationService;
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
