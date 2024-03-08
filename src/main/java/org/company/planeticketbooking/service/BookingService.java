package org.company.planeticketbooking.service;

import org.company.planeticketbooking.domain.booking.Booking;
import org.company.planeticketbooking.domain.booking.EBookingStatus;
import org.company.planeticketbooking.domain.flight.Flight;
import org.company.planeticketbooking.domain.payment.Payment;
import org.company.planeticketbooking.domain.user.User;
import org.company.planeticketbooking.payload.request.BookingRequest;
import org.company.planeticketbooking.payload.response.BookingResponse;
import org.company.planeticketbooking.repository.BookingRepository;
import org.company.planeticketbooking.repository.FlightRepository;
import org.company.planeticketbooking.repository.PaymentRepository;
import org.company.planeticketbooking.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    public BookingService(BookingRepository bookingRepository, PaymentRepository paymentRepository, UserRepository userRepository, FlightRepository flightRepository, ModelMapper modelMapper) {
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.flightRepository = flightRepository;
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

    public BookingRequest createBooking(BookingRequest bookingRequest) {
        Payment payment = paymentRepository.findById(bookingRequest.getPaymentId())
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        User user = userRepository.findById(bookingRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Flight flight = flightRepository.findById(bookingRequest.getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setFlight(flight);
        booking.setBookingTime(bookingRequest.getBookingTime());
        booking.setBookingStatus(EBookingStatus.valueOf(bookingRequest.getBookingStatus()));
        booking.setPayment(payment);
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
