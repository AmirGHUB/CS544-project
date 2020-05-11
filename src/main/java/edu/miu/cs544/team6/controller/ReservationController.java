package com.cs5446.tm.controller;

import com.cs5446.tm.model.Reservation;
import com.cs5446.tm.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations(){
        return reservationService.findAll();
    }
}
