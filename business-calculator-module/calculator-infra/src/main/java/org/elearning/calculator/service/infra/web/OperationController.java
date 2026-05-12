package org.elearning.calculator.service.infra.web;

import org.elearning.calculator.service.application.CalculatorApplicationService;
import org.elearning.calculator.service.infra.web.dtos.OperationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {
    private final CalculatorApplicationService calculatorApplicationService;

    public OperationController(CalculatorApplicationService calculatorApplicationService) {
        this.calculatorApplicationService = calculatorApplicationService;
    }

    @PostMapping("/operations/addition")
    public ResponseEntity<Object> makeAddition(@RequestBody OperationRequest request) {
        return ResponseEntity.ok().body(calculatorApplicationService.makeAddition(request.firstNumber(), request.secondNumber()));
    }
}

