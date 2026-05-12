package org.elearning.domain;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

public abstract class DomainEvent<E> extends ApplicationEvent {
    protected final E data;
    protected LocalDateTime occurredAt;

    public DomainEvent(Object source, E data) {
        super(source);
        this.data = data;
    }

    public DomainEvent(E data) {
        super(data);
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
