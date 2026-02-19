package org.springlearning.springlearning.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.springlearning.springlearning.domain.Event;
import org.springlearning.springlearning.infrastructure.EventSchema;
import java.util.List;

@Mapper(componentModel = "spring", uses = EventFactory.class)
public interface EventMapper {
  Event toDomain(EventSchema eventSchema);
  List<Event> toDomain(List<EventSchema> eventSchemas);
  EventSchema toEntity(Event event);
  List<EventSchema> toEntity(List<Event> events);
}
