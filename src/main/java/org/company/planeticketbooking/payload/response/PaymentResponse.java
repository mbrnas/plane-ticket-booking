package org.company.planeticketbooking.payload.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentResponse {
    private Long paymentId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;
    private String paymentStatus;
}
