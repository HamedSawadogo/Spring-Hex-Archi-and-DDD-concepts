package org.springlearning.springlearning.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AccountCredited implements Event {
    private String eventType;
    private String aggregateId;
    private BigDecimal amount;
    private LocalDateTime occurredAt;
    private String status;

    public AccountCredited(String status, BigDecimal amount, String aggregateId) {
        this.status = status;
        this.amount = amount;
        this.aggregateId = aggregateId;
    }

    @Override
    public String getEventType() {
        return "ACCOUNT_CREDITED";
    }

    @Override
    public LocalDateTime getOccurredAt() {
        return LocalDateTime.now();
    }
}
