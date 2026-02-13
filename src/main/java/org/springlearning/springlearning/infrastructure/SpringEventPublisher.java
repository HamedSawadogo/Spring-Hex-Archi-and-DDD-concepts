package org.springlearning.springlearning.infrastructure;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springlearning.springlearning.application.DomainEventPublisher;
import org.springlearning.springlearning.domain.products.ProductEvent;

@Component
public class SpringEventPublisher implements DomainEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public SpringEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(ProductEvent productEvent) {
        applicationEventPublisher.publishEvent(productEvent);
    }
}
