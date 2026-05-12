package org.elearning.calculator.service.domain;

public class Operation {
    private Long id;
    private int firstNumber;
    private String type;
    private int secondNumber;

    private int result;

    public Operation(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Operation(Long id, int firstNumber, String type, int secondNumber, int result) {
        this.firstNumber = firstNumber;
        this.id = id;
        this.type = type;
        this.secondNumber = secondNumber;
        this.result = result;
    }

    public int addition() {
        this.result =  firstNumber + secondNumber;
        return result;
    }

    public int multiply() {
        this.result = firstNumber * secondNumber;
        return result;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getResult() {
        return result;
    }

    public void markAsCompleted() {
        this.type = "OPERARION_VALIDEE";
    }

    public void markAsFailed() {
        this.type = "OPERATION_REFUSEE";
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", firstNumber=" + firstNumber +
                ", type='" + type + '\'' +
                ", secondNumber=" + secondNumber +
                ", result=" + result +
                '}';
    }
}
