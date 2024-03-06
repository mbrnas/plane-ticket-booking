package org.company.planeticketbooking.service;

import org.company.planeticketbooking.domain.booking.Booking;
import org.company.planeticketbooking.payload.request.BookingRequest;
import org.company.planeticketbooking.payload.response.BookingResponse;
import org.company.planeticketbooking.repository.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;

    public BookingService(BookingRepository bookingRepository, ModelMapper modelMapper) {
        this.bookingRepository = bookingRepository;
        this.modelMapper = modelMapper;
    }

    public List<BookingResponse> getBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(booking -> modelMapper.map(booking, BookingResponse.class))
                .collect(Collectors.toList());
    }

    public BookingResponse getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        return modelMapper.map(booking, BookingResponse.class);
    }

    public BookingRequest createBooking(Booking booking) {
        Booking savedBooking = bookingRepository.save(booking);
        return modelMapper.map(savedBooking, BookingRequest.class);
    }

    public BookingRequest updateBooking(Booking booking) {
        Booking updatedBooking = bookingRepository.save(booking);
        return modelMapper.map(updatedBooking, BookingRequest.class);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
