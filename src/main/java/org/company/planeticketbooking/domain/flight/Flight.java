package org.company.planeticketbooking.domain.flight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.company.planeticketbooking.domain.airline.Airline;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
@RequiredArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    private String flightNumber;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="airline_id", nullable = false)
    private Airline airline;

    private String origin;

    private String destination;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "seats_total")
    private Integer seatsTotal;

    @Column(name = "seats_available")
    private Integer seatsAvailable;

}
