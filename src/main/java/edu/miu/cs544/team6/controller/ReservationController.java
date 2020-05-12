package edu.miu.cs544.team6.controller;

import edu.miu.cs544.team6.domain.Reservation;
import edu.miu.cs544.team6.service.ReservationService;
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
