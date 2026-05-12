package org.elearning.calculator.service.application;

import org.elearning.calculator.service.domain.Operation;
import org.elearning.calculator.service.application.ports.output.repositories.OperationRepository;
import org.springframework.stereotype.Service;


@Service
public class CalculatorApplicationServiceImpl implements CalculatorApplicationService {

    private final MakeAdditionCommandHandler makeAdditionCommandHandler;

    private final OperationRepository operationRepository;


    public CalculatorApplicationServiceImpl(MakeAdditionCommandHandler makeAdditionCommandHandler,
                                            OperationRepository operationRepository) {
        this.makeAdditionCommandHandler = makeAdditionCommandHandler;
        this.operationRepository = operationRepository;
    }

    @Override
    public Operation makeAddition(int firstNumber, int secondeNumber) {
        Operation operation = makeAdditionCommandHandler.handle(firstNumber, secondeNumber);
        return operationRepository.save(operation);

    }
}
