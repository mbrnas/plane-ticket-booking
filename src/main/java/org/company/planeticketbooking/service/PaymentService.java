package org.company.planeticketbooking.service;

import org.company.planeticketbooking.domain.payment.Payment;
import org.company.planeticketbooking.payload.request.PaymentRequest;
import org.company.planeticketbooking.payload.response.PaymentResponse;
import org.company.planeticketbooking.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    public PaymentService(PaymentRepository paymentRepository, ModelMapper modelMapper) {
        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
    }

    public List<PaymentResponse> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(payment -> modelMapper.map(payment, PaymentResponse.class))
                .collect(Collectors.toList());
    }

    public PaymentResponse getPaymentById(Long paymentId) {
        return modelMapper.map(paymentRepository.findById(paymentId).orElse(null), PaymentResponse.class);
    }

    public PaymentResponse createPayment(PaymentRequest paymentRequest) {
        Payment payment = modelMapper.map(paymentRequest, Payment.class);
        return modelMapper.map(paymentRepository.save(payment), PaymentResponse.class);
    }

    public PaymentResponse updatePayment(PaymentRequest paymentRequest) {
        Payment payment = modelMapper.map(paymentRequest, Payment.class);
        return modelMapper.map(paymentRepository.save(payment), PaymentResponse.class);
    }

    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }


}
