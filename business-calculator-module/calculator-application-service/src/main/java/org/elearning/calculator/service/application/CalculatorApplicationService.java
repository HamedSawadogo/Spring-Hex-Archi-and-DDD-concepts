package org.elearning.calculator.service.application;

import org.elearning.calculator.service.domain.Operation;

public interface CalculatorApplicationService {
    Operation makeAddition(int firstNumber, int secondeNumber);
}
