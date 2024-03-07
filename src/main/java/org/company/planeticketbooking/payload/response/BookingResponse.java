package org.company.planeticketbooking.payload.response;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingResponse {
    private Long bookingId;
    private Long userId;
    private Long flightId;
    private LocalDateTime bookingTime;
    private String bookingStatus;
    private Long paymentId;
}
