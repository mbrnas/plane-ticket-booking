package org.company.planeticketbooking.repository;

import org.company.planeticketbooking.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
