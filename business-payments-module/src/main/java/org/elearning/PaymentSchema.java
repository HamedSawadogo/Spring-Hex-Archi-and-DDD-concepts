package org.elearning;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal montant;
    private LocalDateTime date;
    private String status;
    private Long resourceId;
}
