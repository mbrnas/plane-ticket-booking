package org.company.planeticketbooking.controller;

import org.company.planeticketbooking.payload.request.BookingRequest;
import org.company.planeticketbooking.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/add")
    public ResponseEntity<BookingRequest> createBooking(@RequestBody BookingRequest bookingRequest) {
        BookingRequest booking = bookingService.createBooking(bookingRequest);
        return ResponseEntity.ok(booking);
    }
}
