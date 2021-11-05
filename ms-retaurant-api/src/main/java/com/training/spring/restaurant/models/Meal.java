package com.training.spring.restaurant.models;

import java.math.BigDecimal;

public class Meal {

    private String     name;
    private BigDecimal amount;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(final BigDecimal amountParam) {
        this.amount = amountParam;
    }


}
