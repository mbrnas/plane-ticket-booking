package org.company.planeticketbooking.controller;

import org.company.planeticketbooking.domain.flight.Flight;
import org.company.planeticketbooking.service.FlightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/all")
    public void getFlights() {
        flightService.getFlights();
    }

    @GetMapping("/{id}")
    public void getFlightById(@PathVariable Long id) {
        flightService.getFlightById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlightById(@PathVariable Long id) {
        flightService.deleteFlightById(id);
    }

    @PostMapping("/add")
    public void saveFlight(Flight flight) {
        flightService.saveFlight(flight);
    }

    @PutMapping("/update")
    public void updateFlight(Flight flight) {
        flightService.updateFlight(flight);
    }




}
