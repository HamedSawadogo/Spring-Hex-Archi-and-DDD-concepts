package org.springlearning.springlearning.domain.products;

import java.math.BigDecimal;

public class Amount {
    private final BigDecimal value;
    private final String currency;

    public Amount(BigDecimal value, String currency) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("invalid amount");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("inavlid currency");
        }
        this.value = value;
        this.currency = currency;
    }

    public static Amount of(BigDecimal value, String currency) {
        return new Amount(value, currency);
    }

    public static Amount cfa(BigDecimal value) {
        return new Amount(value, "XOF");
    }

    public Amount add(Amount amount)  {
        if (amount.value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("invalid amount");
        }
       // if (!hasSameCurrency())
        //return new Amount()
        return amount;
    }

    private boolean hasSameCurrency(Amount amount) {
        return this.currency.equals(amount.currency);
    }

    public Amount multiply(Amount amount) {
        if (!this.currency.equals(amount.currency)) {
            throw new IllegalArgumentException("imcompatible currency");
        }
        return new Amount(this.value.multiply(amount.value), amount.currency);
    }
}
