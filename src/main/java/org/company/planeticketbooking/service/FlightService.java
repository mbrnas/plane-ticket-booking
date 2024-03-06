package org.company.planeticketbooking.service;

import org.company.planeticketbooking.domain.airline.Airline;
import org.company.planeticketbooking.domain.flight.Flight;
import org.company.planeticketbooking.payload.response.FlightResponse;
import org.company.planeticketbooking.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final AirlineService airlineService;
    private final ModelMapper modelMapper;

    public FlightService(FlightRepository flightRepository, AirlineService airlineService, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.airlineService = airlineService;
        this.modelMapper = modelMapper;
    }

    public List<FlightResponse> getFlights(){
        List<Flight> flights = flightRepository.findAll();
        return flights.stream()
                .map(flight -> {
                    FlightResponse flightResponse = modelMapper.map(flight, FlightResponse.class);
                    flightResponse.setAirlineName(String.valueOf(flight.getAirline().getAirlineId()));
                    flightResponse.setAirlineName(flight.getAirline().getAirlineName());
                    return flightResponse;
                })
                .collect(Collectors.toList());
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }

    public void saveFlight(Flight flight, Long airlineId) {
        Airline airline = airlineService.getAirlineById(airlineId)
                .orElseThrow(() -> new RuntimeException("Airline not found with id: " + airlineId));
        flight.setAirline(airline);
        flightRepository.save(flight);
    }


    public void updateFlight(Flight flight, Long airlineId) {
        Airline airline = airlineService.getAirlineById(airlineId)
                .orElseThrow(() -> new RuntimeException("Airline not found with id: " + airlineId));
        flight.setAirline(airline);
        flightRepository.save(flight);
    }


}
