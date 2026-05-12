package org.elearning.calculator.service.application.ports.output.message.publisher;

import org.elearning.calculator.service.domain.OperationValidated;

public interface CalculatorServiceEventPublisher {
    void publish(OperationValidated event);
}
