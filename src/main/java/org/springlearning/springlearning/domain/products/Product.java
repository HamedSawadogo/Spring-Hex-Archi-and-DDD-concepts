package org.springlearning.springlearning.domain.products;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private ProductId productId;
    private Amount amount;
    private String title;
    private Quantity quantity;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private ProductStatus productStatus;
    private final List<ProductEvent> domainEvents = new ArrayList<>();

    public Product(Amount amount, String title, Quantity quantity, String description) {
        this.productId = new ProductId();
        this.amount = amount;
        this.title = title;
        this.quantity = quantity;
        this.description = description;
    }

    Product() {

    }

    public boolean isAvailable() {
        return this.quantity.getValue() > 0;
    }

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public List<ProductEvent> getDomainEvents() {
        return domainEvents;
    }
}
