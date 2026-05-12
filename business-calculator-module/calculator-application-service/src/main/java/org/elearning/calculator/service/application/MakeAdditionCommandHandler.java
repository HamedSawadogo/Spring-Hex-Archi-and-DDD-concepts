package org.elearning.calculator.service.application;


import org.elearning.calculator.service.application.ports.output.message.publisher.CalculatorServiceEventPublisher;
import org.elearning.calculator.service.application.ports.output.repositories.OperationRepository;
import org.elearning.calculator.service.domain.Operation;
import org.elearning.calculator.service.domain.OperationDomainService;
import org.elearning.calculator.service.application.ports.input.MakeAddition;
import org.elearning.calculator.service.domain.OperationValidated;
import org.springframework.stereotype.Component;

@Component
public class MakeAdditionCommandHandler implements MakeAddition {

    private final OperationDomainService operationDomainService;

    private final OperationRepository operationRepository;

    private final CalculatorServiceEventPublisher calculatorServiceEventPublisher;

    public MakeAdditionCommandHandler(OperationDomainService operationDomainService,
                                      OperationRepository operationRepository,
                                      CalculatorServiceEventPublisher calculatorServiceEventPublisher) {
        this.operationDomainService = operationDomainService;
        this.operationRepository = operationRepository;
        this.calculatorServiceEventPublisher = calculatorServiceEventPublisher;
    }

    @Override
    public Operation handle(int firstNumber, int secondNumber) {
        Operation operation = operationDomainService.addition(firstNumber, secondNumber);
        Operation save = operationRepository.save(operation);
        OperationValidated operationValidated = new OperationValidated( save);
        calculatorServiceEventPublisher.publish(operationValidated);
        return save;

    }
}
