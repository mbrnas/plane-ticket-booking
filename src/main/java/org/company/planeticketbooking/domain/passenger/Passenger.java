package org.company.planeticketbooking.domain.passenger;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.company.planeticketbooking.domain.booking.Booking;

@Entity
@Table(name = "passengers")
@Getter
@Setter
@RequiredArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="booking_id", nullable = false)
    private Booking booking;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="passport_number")
    private String passportNumber;

    @Column(name="special_requests")
    private String specialRequests;
}
