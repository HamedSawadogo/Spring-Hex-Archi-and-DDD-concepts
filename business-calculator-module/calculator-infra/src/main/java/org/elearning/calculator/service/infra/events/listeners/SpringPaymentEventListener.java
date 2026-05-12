package org.elearning.calculator.service.infra.events.listeners;

import org.elearning.calculator.service.application.ports.input.messsges.listeners.CalculatorPaymentEventListener;
import org.elearning.domain.PaymentFailed;
import org.elearning.domain.PaymentProcessedSuccessFully;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SpringPaymentEventListener  {

    private final CalculatorPaymentEventListener paymentEventListener;

    public SpringPaymentEventListener(CalculatorPaymentEventListener paymentEventListener) {
        this.paymentEventListener = paymentEventListener;
    }

    @EventListener
    public void onPaymentSucess(PaymentProcessedSuccessFully processedSuccessFully) {
        paymentEventListener.onPaymentSucess(processedSuccessFully);
    }

    @EventListener
    public void onPaymentFailed(PaymentFailed paymentFailedEvent) {
        System.err.println("Failed:  " + paymentFailedEvent);
        paymentEventListener.onPaymentFailed(paymentFailedEvent);
    }
}
