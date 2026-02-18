package org.springlearning.springlearning.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountCredited implements Event {
    private Long id;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private String status;

    public AccountCredited(Long id, BigDecimal amount, LocalDateTime createdAt, String status) {
    }
}
