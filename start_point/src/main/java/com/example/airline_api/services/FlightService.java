package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;


    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight findFlight(Long id) {
        return flightRepository.findById(id).get();
    }

    public Flight saveFlight(FlightDTO flightDTO) {
        Flight flight = new Flight(flightDTO.getDestination(), flightDTO.getCapacity(), flightDTO.getDepartureDate(), flightDTO.getDepartureTime());
        flightRepository.save(flight);
        return flight;
    }

@Transactional
    public Flight addPassengerToFlight(FlightDTO flightDTO, Long id) {
        Flight flight = flightRepository.findById(id).get();
        for (Long passengerIds : flightDTO.getPassengerIds()){
            Passenger passenger = passengerRepository.findById(passengerIds).get();
            flight.addPassenger(passenger);
        }
        flightRepository.save(flight);
        return flight;
    }


    public void cancelFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
