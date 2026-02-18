package org.springlearning.springlearning.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreated implements Event {
    private Long id;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private String status;
}
