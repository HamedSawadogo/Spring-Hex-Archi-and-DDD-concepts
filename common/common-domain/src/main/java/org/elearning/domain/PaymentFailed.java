package org.elearning.domain;


public class PaymentFailed extends DomainEvent<Payment> {

    public PaymentFailed(Payment data) {
        super(data);
    }
}
