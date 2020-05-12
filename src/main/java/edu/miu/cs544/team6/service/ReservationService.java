package edu.miu.cs544.team6.service;

import edu.miu.cs544.team6.domain.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> findAll();
}
