package org.company.planeticketbooking.controller;

import org.company.planeticketbooking.payload.request.PaymentRequest;
import org.company.planeticketbooking.payload.response.FlightResponse;
import org.company.planeticketbooking.payload.response.PaymentResponse;
import org.company.planeticketbooking.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/all")
    public List<PaymentResponse> getPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public PaymentResponse getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/add")
    public PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.createPayment(paymentRequest);
    }

    @PutMapping("/update")
    public PaymentResponse updatePayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.updatePayment(paymentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePaymentById(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }


}
