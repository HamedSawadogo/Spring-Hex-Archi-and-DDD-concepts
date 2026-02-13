package org.springlearning.springlearning.application;

import org.springlearning.springlearning.domain.products.Amount;
import org.springlearning.springlearning.domain.products.Product;
import org.springlearning.springlearning.domain.products.Quantity;
import java.math.BigDecimal;

public record CreateProductCommand(String name, String description, BigDecimal price, int quantity) {
  public Product toDomain() {
      return new Product(Amount.cfa(price), name, new Quantity(quantity), description);
  }
}
