package org.springlearning.springlearning.domain.products;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductAggregate {
    private ProductId productId;
    private Amount amount;
    private String title;
    private Quantity quantity;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private ProductStatus productStatus;
    private final List<ProductEvent> domainEvents = new ArrayList<>();

    public boolean isAvailable() {
        return this.quantity.getValue() > 0;
    }

}
