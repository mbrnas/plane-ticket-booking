package org.company.planeticketbooking.domain.booking;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.company.planeticketbooking.domain.flight.Flight;
import org.company.planeticketbooking.domain.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@RequiredArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="flight_id", nullable = false)
    private Flight flight;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    private String status;

    @Column(name = "payment_status")
    private String paymentStatus;
}
