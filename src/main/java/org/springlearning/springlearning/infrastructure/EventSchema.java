package org.springlearning.springlearning.infrastructure;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@Table
@NoArgsConstructor @AllArgsConstructor
public class EventSchema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  eventId;
    private String aggregateId;
    private String eventType;
    private LocalDateTime occurredAt;
    private String data;
}
