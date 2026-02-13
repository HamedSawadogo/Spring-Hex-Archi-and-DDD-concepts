package org.springlearning.springlearning.domain.products;

import java.time.Instant;

public interface  ProductEvent {
   default Instant occurredOn() {
       return Instant.now();
   }
}
