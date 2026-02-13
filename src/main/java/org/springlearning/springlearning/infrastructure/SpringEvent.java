package org.springlearning.springlearning.infrastructure;

import org.springframework.context.ApplicationEvent;
import org.springlearning.springlearning.domain.products.ProductEvent;

public class SpringEvent extends ApplicationEvent implements ProductEvent {
    public SpringEvent(Object source) {
        super(source);
    }
}
