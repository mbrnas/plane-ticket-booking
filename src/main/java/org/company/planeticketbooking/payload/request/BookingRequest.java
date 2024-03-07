package org.company.planeticketbooking.payload.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingRequest {
    private Long userId;
    private Long flightId;
    private LocalDateTime bookingTime;
    private String bookingStatus;
    private Long paymentId;
}
