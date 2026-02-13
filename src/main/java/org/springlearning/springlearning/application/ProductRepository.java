package org.springlearning.springlearning.application;

import org.springlearning.springlearning.domain.products.Product;
import org.springlearning.springlearning.domain.products.ProductId;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product create(Product product);
    List<Product> findAll();
    Optional<Product> findOne(ProductId id);
    void delete(ProductId id);
    boolean existByName(String name);
}
