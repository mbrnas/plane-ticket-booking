package org.company.planeticketbooking.controller;

import org.company.planeticketbooking.domain.flight.Flight;
import org.company.planeticketbooking.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/all")
    public List<Flight> getFlights() {
        return flightService.getFlights();
    }

    @GetMapping("/{id}")
    public void getFlightById(@PathVariable Long id) {
        flightService.getFlightById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlightById(@PathVariable Long id) {
        flightService.deleteFlightById(id);
    }

    @PostMapping("/add/{airlineId}")
    public void saveFlight(@RequestBody Flight flight, @PathVariable Long airlineId) {
        flightService.saveFlight(flight, airlineId);
    }

    @PutMapping("/update/{airlineId}")
    public void updateFlight(@RequestBody Flight flight, @PathVariable Long airlineId) {
        flightService.updateFlight(flight, airlineId);
    }
}
