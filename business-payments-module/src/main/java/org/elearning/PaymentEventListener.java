package org.elearning;

import lombok.RequiredArgsConstructor;
import org.elearning.calculator.service.infra.events.publisher.OperationValidatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentEventListener {

    private final PaymentService paymentService;

    @EventListener
    public void onOperationSuccess(OperationValidatedEvent operationValidated) {
        BigDecimal targetAmount = BigDecimal.valueOf(operationValidated.getOperationValidated().getData().getResult());
        BigDecimal userAmount  = BigDecimal.valueOf(operationValidated.getOperationValidated().getData().getResult());
        paymentService.makePayment(userAmount, targetAmount, operationValidated.getOperationValidated().getData().getId());
    }
}
