package org.company.planeticketbooking.controller;

import org.company.planeticketbooking.payload.request.BookingRequest;
import org.company.planeticketbooking.payload.response.BookingResponse;
import org.company.planeticketbooking.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingResponse>> getBookings() {
        return ResponseEntity.ok(bookingService.getBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBookingById(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @PostMapping("/add")
    public ResponseEntity<BookingRequest> createBooking(@RequestBody BookingRequest bookingRequest) {
        BookingRequest booking = bookingService.createBooking(bookingRequest);
        return ResponseEntity.ok(booking);
    }
}
