package org.elearning.domain;

public class DomainRuleViolationException extends RuntimeException {
    public DomainRuleViolationException(String message) {
        super(message);
    }
}
