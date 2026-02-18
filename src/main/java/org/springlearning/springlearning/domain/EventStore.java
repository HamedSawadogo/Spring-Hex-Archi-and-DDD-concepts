package org.springlearning.springlearning.domain;

import java.util.List;

public interface EventStore {
    List<Event> loadEventsById(String id);
    void storeEvents(List<Event> events);
}
