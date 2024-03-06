package org.company.planeticketbooking.service;

import org.company.planeticketbooking.domain.flight.Flight;
import org.company.planeticketbooking.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void getFlights() {
        flightRepository.findAll();
    }

    public void getFlightById(Long id) {
        flightRepository.findById(id);
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }

    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void updateFlight(Flight flight) {
        flightRepository.save(flight);
    }


}
