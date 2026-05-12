package org.elearning.calculator.service.domain;

import org.elearning.domain.DomainEvent;

public class OperationValidated extends DomainEvent<Operation> {
    public OperationValidated(Operation data) {
        super(data);
    }
}
