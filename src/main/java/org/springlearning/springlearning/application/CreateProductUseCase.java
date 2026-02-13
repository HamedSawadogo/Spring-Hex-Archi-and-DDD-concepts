package org.springlearning.springlearning.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springlearning.springlearning.domain.products.Product;
import org.springlearning.springlearning.domain.products.ProductCreatedEvent;

@Service
@Transactional
public class CreateProductUseCase {
    private final ProductRepository productRepository;
    private final DomainEventPublisher domainEventPublisher;

    public CreateProductUseCase(ProductRepository productRepository, DomainEventPublisher domainEventPublisher) {
        this.productRepository = productRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    public Product execute(CreateProductCommand command) {
        if (productRepository.existByName(command.name())) {
            throw new BusinessException("product already exist by this name");
        }
        Product product = productRepository.create(command.toDomain());
        domainEventPublisher.publish(new ProductCreatedEvent(product.getProductId()));
        return product;
    }
}
