package org.springlearning.springlearning.infrastructure;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springlearning.springlearning.application.DomainEventPublisher;
import org.springlearning.springlearning.domain.products.ProductCreatedEvent;
import org.springlearning.springlearning.domain.products.ProductEvent;

@Component
public class EventPublisher implements DomainEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;
    public EventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(ProductEvent productEvent) {
        if (productEvent instanceof ProductCreatedEvent) {
            System.err.println("product created");
        }
    }
}
