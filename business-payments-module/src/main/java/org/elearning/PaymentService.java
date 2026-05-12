package org.elearning;

import lombok.Getter;
import org.elearning.domain.Payment;
import org.elearning.domain.PaymentFailed;
import org.elearning.domain.PaymentProcessedSuccessFully;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public PaymentService(PaymentRepository paymentRepository,
                          ApplicationEventPublisher applicationEventPublisher) {
        this.paymentRepository = paymentRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    public PaymentSchema makePayment(BigDecimal userAmount, BigDecimal calculAmont, Long id) {

        PaymentSchema payment = PaymentSchema.builder()
                .montant(userAmount)
                .date(LocalDateTime.now())
                .build();

        if (userAmount.compareTo(BigDecimal.ZERO) <= 0 || calculAmont.compareTo(BigDecimal.ZERO) <= 0) {
            payment.setStatus("FAILED");

            Payment domainPayment = new Payment();
            domainPayment.setId(id);
            domainPayment.setStatus("FAILED");
            domainPayment.setMontant(userAmount);
            domainPayment.setDate(LocalDateTime.now());
            PaymentFailed paymentFailed = new PaymentFailed(domainPayment);

            System.err.println(domainPayment);
            applicationEventPublisher.publishEvent(paymentFailed);
        }
        else if (calculAmont.compareTo(userAmount) <= 0) {
            payment.setStatus("FAILED");

            Payment domainPayment = new Payment();
            domainPayment.setId(id);
            domainPayment.setStatus("FAILED");
            domainPayment.setMontant(userAmount);
            domainPayment.setDate(LocalDateTime.now());

            PaymentFailed paymentFailed = new PaymentFailed(domainPayment);

            System.err.println(domainPayment);

            System.err.println(paymentFailed);
            applicationEventPublisher.publishEvent(paymentFailed);
        } else {
            payment.setStatus("SUCCESS");

            Payment domainPayment = new Payment();
            domainPayment.setId(id);
            domainPayment.setStatus("SUCCESS");
            domainPayment.setMontant(userAmount);
            domainPayment.setDate(LocalDateTime.now());
            PaymentProcessedSuccessFully processedSuccessFully = new PaymentProcessedSuccessFully(domainPayment);
            applicationEventPublisher.publishEvent(processedSuccessFully);
        }
        paymentRepository.save(payment);
        return payment;
    }
}

