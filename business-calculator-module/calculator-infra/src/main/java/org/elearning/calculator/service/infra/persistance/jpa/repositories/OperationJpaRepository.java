package org.elearning.calculator.service.infra.persistance.jpa.repositories;

import org.elearning.calculator.service.infra.persistance.jpa.schemas.OperationShema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationJpaRepository extends JpaRepository<OperationShema, Long> {
}
