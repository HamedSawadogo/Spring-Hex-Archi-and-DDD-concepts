package org.springlearning.springlearning.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AccountCreated implements Event {
    private String eventType;
    private String aggregateId;
    private BigDecimal amount;
    private LocalDateTime occurredAt;
    private String status;

    public AccountCreated(String aggregateId, BigDecimal amount, String status) {
        this.aggregateId = aggregateId;
        this.amount = amount;
        this.status = status;
    }

    @Override
    public String getEventType() {
        return "ACCOUNT_CREATED";
    }

    @Override
    public LocalDateTime getOccurredAt() {
        return LocalDateTime.now();
    }
}
