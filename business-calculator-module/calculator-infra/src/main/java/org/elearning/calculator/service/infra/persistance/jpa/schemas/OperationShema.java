package org.elearning.calculator.service.infra.persistance.jpa.schemas;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OperationShema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int firstNumber;
    private String type;
    private int secondNumber;
    private int result;
}
