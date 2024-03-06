package org.company.planeticketbooking.repository;

import org.company.planeticketbooking.domain.airline.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Long>{
}
