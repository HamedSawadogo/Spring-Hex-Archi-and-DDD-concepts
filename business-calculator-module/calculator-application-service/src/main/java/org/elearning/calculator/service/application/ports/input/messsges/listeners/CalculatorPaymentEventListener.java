package org.elearning.calculator.service.application.ports.input.messsges.listeners;

import org.elearning.domain.PaymentFailed;
import org.elearning.domain.PaymentProcessedSuccessFully;

public interface CalculatorPaymentEventListener {
    void onPaymentSucess(PaymentProcessedSuccessFully processedSuccessFully);
    void onPaymentFailed(PaymentFailed paymentFailed);
}
