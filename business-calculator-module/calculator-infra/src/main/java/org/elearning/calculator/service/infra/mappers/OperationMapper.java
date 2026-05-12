package org.elearning.calculator.service.infra.mappers;

import org.elearning.calculator.service.domain.Operation;
import org.elearning.calculator.service.infra.persistance.jpa.schemas.OperationShema;
import org.springframework.stereotype.Component;

@Component
public class OperationMapper {
    public static Operation toDomain(OperationShema operation) {
        return new Operation(
                operation.getId(),
                operation.getFirstNumber(),
                operation.getType(),
                operation.getSecondNumber(),
                operation.getResult()
        );
    }

    public static OperationShema toJpaEntity(Operation operation) {
        return OperationShema.builder()
                .id(operation.getId())
                .firstNumber(operation.getFirstNumber())
                .secondNumber(operation.getSecondNumber()
                ).result(operation.getResult())
                .build();
    }


}
