package org.elearning.calculator.service.infra.configs;


import org.elearning.calculator.service.application.PaymentEventListenerImpl;
import org.elearning.calculator.service.application.ports.input.messsges.listeners.CalculatorPaymentEventListener;
import org.elearning.calculator.service.domain.OperationDomainService;
import org.elearning.calculator.service.domain.OperationDomainServiceImpl;
import org.elearning.calculator.service.infra.persistance.jpa.repositories.OperationRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorDomainBeanConfig {

    @Bean
    public OperationDomainService operationDomainService() {
        return new OperationDomainServiceImpl();
    }

    @Bean
    public CalculatorPaymentEventListener calculatorPaymentEventListener(OperationRepositoryImpl operationRepository)  {
        return new PaymentEventListenerImpl(operationRepository);
    }

}
