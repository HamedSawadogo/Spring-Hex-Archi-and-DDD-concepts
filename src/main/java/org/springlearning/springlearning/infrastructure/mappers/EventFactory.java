package org.springlearning.springlearning.infrastructure.mappers;

import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import org.springlearning.springlearning.domain.AccountCreated;
import org.springlearning.springlearning.domain.AccountCredited;
import org.springlearning.springlearning.domain.Event;
import org.springlearning.springlearning.infrastructure.EventSchema;

@Component
public class EventFactory {

    @ObjectFactory
    public Event create(EventSchema dto) {
        return switch (dto.getEventType()) {
            case "ACCOUNT_CREATED" -> new AccountCreated();
            case "ACCOUNT_CREDITED" -> new AccountCredited();
            default -> throw new IllegalArgumentException("Unknown event");
        };
    }
}
