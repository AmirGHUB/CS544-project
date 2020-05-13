package edu.miu.cs544.team6.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.team6.domain.Reservation;
import edu.miu.cs544.team6.domain.User;
import edu.miu.cs544.team6.dto.ReservationDTO;
import edu.miu.cs544.team6.dto.UserDTO;
import edu.miu.cs544.team6.service.ReservationService;

@RestController
@RequestMapping("/Reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
    private ModelMapper modelMapper;
	
    @PostMapping()
    public void createResevation(@RequestBody Reservation reservation) {
    	reservationService.save(reservation);
    }
    
    @GetMapping()
    public List<ReservationDTO> getReservations(){
    	return reservationService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{reservationId}")
    public Reservation getReservationById(@PathVariable int reservationId) {
    	return reservationService.findById(reservationId);
    }
    
    @PostMapping("/{reservationId}")
    public Reservation updateById(@PathVariable int reservationId) {
    	return reservationService.update(reservationId);
    }
    
    @DeleteMapping("/{reservationId}")
    public void deleteReservation(@PathVariable int reservationId) {
    	reservationService.delete(reservationId);
    }
    
    /** from system to user Map to ReservationDTO**/
    private ReservationDTO convertToDTO(Reservation reservation) {
    	ReservationDTO reservationDTO = modelMapper.map(reservation, ReservationDTO.class);  
        return reservationDTO;
    }

}
