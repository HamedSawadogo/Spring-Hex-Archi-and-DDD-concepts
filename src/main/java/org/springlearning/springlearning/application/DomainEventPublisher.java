package org.springlearning.springlearning.application;

import org.springlearning.springlearning.domain.products.ProductEvent;

public interface DomainEventPublisher {
    void publish(ProductEvent event);
}
