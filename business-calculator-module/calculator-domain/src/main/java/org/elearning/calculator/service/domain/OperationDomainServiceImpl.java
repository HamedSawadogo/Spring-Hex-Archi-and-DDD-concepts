package org.elearning.calculator.service.domain;


public class OperationDomainServiceImpl implements OperationDomainService {
    @Override
    public Operation addition(int firstNumber, int secondNumber) {
        Operation operation = new Operation(firstNumber, secondNumber);
        operation.addition();
        return operation;
    }
}
