package org.springlearning.springlearning.domain;

import java.time.LocalDateTime;

public interface Event {
    String getEventType();
    String getAggregateId();
    LocalDateTime getOccurredAt();
}
