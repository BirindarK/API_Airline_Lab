package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception{

        Flight flight1 = new Flight("Saint Lucia", 200, "22.03.2024", "10:30");
        flightRepository.save(flight1);

        Passenger passenger1 = new Passenger("Birindar","Birindar@gmail.com");
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("Karan", "Karan@gmail.com");
        passengerRepository.save(passenger2);

        Flight flight2 = new Flight("London", 200, "24.06.2024","20:00");
        flightRepository.save(flight2);

        Passenger passenger3 = new Passenger("Tavneet","Tavneet@gmail.com");
        passengerRepository.save(passenger3);

        Passenger passenger4 = new Passenger("Mina","Mina@gmail.com");
        passengerRepository.save(passenger4);

        Flight flight3 = new Flight("Dubai", 250, "23.09.2024","08:00");
        flightRepository.save(flight3);

        Passenger passenger5 = new Passenger("Mandish","Mandish@gmail.com");
        passengerRepository.save(passenger5);

        Passenger passenger6 = new Passenger("Sukhi","Sukhi@gmail.com");
        passengerRepository.save(passenger6);


    }



}
