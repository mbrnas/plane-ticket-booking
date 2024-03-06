package org.company.planeticketbooking.repository;

import org.company.planeticketbooking.domain.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long>{
}
