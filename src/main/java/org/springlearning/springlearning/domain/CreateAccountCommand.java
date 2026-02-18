package org.springlearning.springlearning.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateAccountCommand implements Commmnand {
    private Long id;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private String status;
}
