package org.elearning.calculator.service.application;

import org.elearning.calculator.service.application.ports.input.messsges.listeners.CalculatorPaymentEventListener;
import org.elearning.calculator.service.application.ports.output.repositories.OperationRepository;
import org.elearning.calculator.service.domain.Operation;
import org.elearning.domain.PaymentFailed;
import org.elearning.domain.PaymentProcessedSuccessFully;

public class PaymentEventListenerImpl implements CalculatorPaymentEventListener {

    private final OperationRepository operationRepository;

    public PaymentEventListenerImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public void onPaymentSucess(PaymentProcessedSuccessFully processedSuccessFully) {
        Operation operation =
                operationRepository.findById(processedSuccessFully.getData().getId()).orElseThrow();
        operation.markAsCompleted();
        operationRepository.save(operation);
    }

    @Override
    public void onPaymentFailed(PaymentFailed paymentFailed) {
        Operation operation =
                operationRepository.findById(paymentFailed.getData().getId()).orElseThrow();
        operation.markAsFailed();
        operationRepository.save(operation);
        System.err.println(operation);

    }
}
