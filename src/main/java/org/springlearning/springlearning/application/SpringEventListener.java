package org.springlearning.springlearning.application;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SpringEventListener  {

    @EventListener
    public void listen(Object event) {

    }
}
