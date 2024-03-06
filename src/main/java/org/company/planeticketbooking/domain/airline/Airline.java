package org.company.planeticketbooking.domain.airline;

import jakarta.persistence.*;

@Entity
@Table(name = "airlines")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airlineId;

    private String airlineName;
}
