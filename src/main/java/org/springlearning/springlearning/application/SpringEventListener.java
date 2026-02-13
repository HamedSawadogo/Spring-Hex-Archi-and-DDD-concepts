package org.springlearning.springlearning.application;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springlearning.springlearning.domain.products.ProductCreatedEvent;
import org.springlearning.springlearning.domain.products.ProductEvent;

@Component
public class SpringEventListener  {

    @EventListener
    public void listen(ProductEvent event) {
        if (event instanceof ProductCreatedEvent productCreated) {
            System.err.println("Product Created");
            //TODO send analysis service
        }
    }
}
