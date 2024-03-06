package org.company.planeticketbooking.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class FlightResponse {
    private Long flightId;
    private String flightNumber;
    private Long airlineId;
    private String airlineName;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private BigDecimal price;
    private Integer seatsTotal;
    private Integer seatsAvailable;
}