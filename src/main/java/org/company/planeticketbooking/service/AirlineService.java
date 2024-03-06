package org.company.planeticketbooking.service;

import org.company.planeticketbooking.domain.airline.Airline;
import org.company.planeticketbooking.repository.AirlineRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirlineService {
    private final AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public void getAirlines() {
        airlineRepository.findAll();
    }

    public Optional<Airline> getAirlineById(Long id) {
        return airlineRepository.findById(id);
    }

    public void deleteAirlineById(Long id) {
        airlineRepository.deleteById(id);
    }

    public void saveAirline(Airline airline) {
        airlineRepository.save(airline);
    }

    public void updateAirline(Airline airline) {
        airlineRepository.save(airline);
    }

}
