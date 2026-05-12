package org.elearning.calculator.service.infra.persistance.jpa.repositories;

import lombok.RequiredArgsConstructor;
import org.elearning.calculator.service.application.ports.output.repositories.OperationRepository;
import org.elearning.calculator.service.domain.Operation;
import org.elearning.calculator.service.infra.mappers.OperationMapper;
import org.elearning.calculator.service.infra.persistance.jpa.schemas.OperationShema;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OperationRepositoryImpl implements OperationRepository {

    private final OperationJpaRepository operationJpaRepository;

    @Override
    public Operation save(Operation operation) {
        OperationShema operationShema = OperationMapper.toJpaEntity(operation);
        OperationShema saved = operationJpaRepository.save(operationShema);
        return OperationMapper.toDomain(saved);
    }

    @Override
    public Optional<Operation> findById(Long id) {
        var operationShema = operationJpaRepository.findById(id).orElseThrow();
        return Optional.of(OperationMapper.toDomain(operationShema));
    }
}
