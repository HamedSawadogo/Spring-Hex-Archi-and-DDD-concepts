package org.springlearning.springlearning.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<EventSchema, Long> {
    List<EventSchema> findAllByAggregateId(String aggregateId);
}
