package org.elearning.calculator.service.application.ports.input;

import jakarta.validation.Valid;
import org.elearning.calculator.service.domain.Operation;

public interface MakeAddition {
    Operation handle(@Valid int firstNumber, @Valid  int secondNumber);
}