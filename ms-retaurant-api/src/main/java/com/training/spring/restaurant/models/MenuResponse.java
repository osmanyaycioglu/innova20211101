package com.training.spring.restaurant.models;

import java.math.BigDecimal;

public class MenuResponse {

    private BigDecimal price;


    public BigDecimal getPrice() {
        return this.price;
    }


    public void setPrice(final BigDecimal priceParam) {
        this.price = priceParam;
    }


}
