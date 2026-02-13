package org.springlearning.springlearning.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springlearning.springlearning.application.ProductRepository;
import org.springlearning.springlearning.domain.products.Product;
import org.springlearning.springlearning.domain.products.ProductId;

import java.util.List;
import java.util.Optional;

@Service
public class ProductJpaRepository implements ProductRepository {
    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Optional<Product> findOne(ProductId id) {
        return Optional.empty();
    }

    @Override
    public void delete(ProductId id) {

    }

    @Override
    public boolean existByName(String name) {
        return false;
    }
}
