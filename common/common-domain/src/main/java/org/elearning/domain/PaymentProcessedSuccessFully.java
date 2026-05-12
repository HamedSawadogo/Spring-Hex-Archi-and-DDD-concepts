package org.elearning.domain;

public class PaymentProcessedSuccessFully extends DomainEvent<Payment> {
    public PaymentProcessedSuccessFully(Payment data) {
        super(data);
    }
}
