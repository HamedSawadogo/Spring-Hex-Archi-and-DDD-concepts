package org.springlearning.springlearning.domain.products;

import java.time.Instant;

public class ProductCreatedEvent implements ProductEvent {
    private final ProductId productId;

    public ProductCreatedEvent(ProductId productId) {
        this.productId = productId;
    }

    @Override
    public Instant occurredOn() {
        return Instant.now();
    }

    public ProductId getProductId() {
        return productId;
    }
}
