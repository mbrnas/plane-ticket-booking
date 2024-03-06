package org.company.planeticketbooking.payload.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentRequest {
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;
    private String paymentStatus;
}