package com.example.airline_api.services;


import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }


    public Passenger findPassengerById(Long id) {
        return passengerRepository.findById(id).get();
    }

    public Passenger addNewPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getEmail());
        passengerRepository.save(passenger);
        return passenger;
    }
}
