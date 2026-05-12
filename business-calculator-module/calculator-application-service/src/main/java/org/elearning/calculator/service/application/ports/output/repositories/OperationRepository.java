package org.elearning.calculator.service.application.ports.output.repositories;

import org.elearning.calculator.service.domain.Operation;

import java.util.Optional;

public interface OperationRepository {
    Operation save(Operation operation);

    Optional<Operation> findById(Long id);
}
