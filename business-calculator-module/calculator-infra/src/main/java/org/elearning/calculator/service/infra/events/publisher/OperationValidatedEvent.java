package org.elearning.calculator.service.infra.events.publisher;

import lombok.Getter;
import org.elearning.calculator.service.domain.OperationValidated;
import org.springframework.context.ApplicationEvent;

@Getter
public class OperationValidatedEvent  extends ApplicationEvent {
    private final OperationValidated operationValidated;


    public OperationValidatedEvent(Object source, OperationValidated operationValidated) {
        super(source);
        this.operationValidated = operationValidated;
    }
}
