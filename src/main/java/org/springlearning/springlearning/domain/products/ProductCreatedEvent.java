package org.springlearning.springlearning.domain.products;

import java.time.LocalDateTime;

public class ProductCreatedEvent extends ProductEvent {
    public ProductCreatedEvent(ProductId productId, LocalDateTime localDateTime) {
        super(productId, localDateTime);
    }
}
