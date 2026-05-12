package org.elearning.calculator.service.infra.events.publisher;

import lombok.Getter;
import org.elearning.calculator.service.application.ports.output.message.publisher.CalculatorServiceEventPublisher;
import org.elearning.calculator.service.domain.OperationValidated;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationEventPublisher implements CalculatorServiceEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public SpringApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(OperationValidated event) {
        OperationValidatedEvent operationValidatedEvent = new OperationValidatedEvent(this, event);
        this.applicationEventPublisher.publishEvent(operationValidatedEvent);
    }


}

