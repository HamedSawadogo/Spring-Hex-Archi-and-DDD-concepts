package org.springlearning.springlearning.infrastructure;

import org.springframework.stereotype.Repository;
import org.springlearning.springlearning.domain.Event;
import org.springlearning.springlearning.domain.EventStore;
import org.springlearning.springlearning.infrastructure.mappers.EventMapper;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Repository
public class DatabaseEventStore implements EventStore {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final ObjectMapper objectMapper;

    public DatabaseEventStore(EventRepository eventRepository, EventMapper eventMapper, ObjectMapper objectMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Event> loadEventsById(String id) {
        return eventMapper.toDomain(eventRepository.findAllByAggregateId(id));
    }

    @Override
    public void storeEvents(List<Event> events) {
        var eventSchemas = events.stream().map(event -> {
            var eventMapped = eventMapper.toEntity(event);
            eventMapped.setOccurredAt(event.getOccurredAt());
            eventMapped.setAggregateId(event.getAggregateId());
            eventMapped.setData(objectMapper.writeValueAsString(event));
            return eventMapped;
        }).toList();
        eventRepository.saveAll(eventSchemas);
    }
}
