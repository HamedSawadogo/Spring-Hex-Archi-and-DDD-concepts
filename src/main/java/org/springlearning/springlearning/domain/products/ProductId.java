package org.springlearning.springlearning.domain.products;

import org.springframework.util.Assert;

import java.util.UUID;

public record ProductId(UUID productId) {
    public ProductId {
        Assert.notNull(productId, "BookId should not be null!");
    }
    public ProductId()  {
        this(UUID.randomUUID());
    }
}
