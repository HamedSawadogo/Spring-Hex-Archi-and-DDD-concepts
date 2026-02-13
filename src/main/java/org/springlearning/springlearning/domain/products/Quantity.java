package org.springlearning.springlearning.domain.products;

public class Quantity {
    private final int  value;

    public Quantity(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("inavlid quantity");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Quantity  add(int value) {
        return new Quantity(this.value + value);
    }

    public Quantity minus(int value) {
        return new Quantity(this.value - value);
    }
}
