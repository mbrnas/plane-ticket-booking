package org.company.planeticketbooking.repository;

import org.company.planeticketbooking.domain.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
