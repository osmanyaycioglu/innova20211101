package com.training.spring.restaurant.models;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MenuRequest {

    @NotNull
    @Size(min = 1)
    private List<Meal> meals;
    @NotNull
    private String     phone;

    public List<Meal> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<Meal> mealsParam) {
        this.meals = mealsParam;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phoneParam) {
        this.phone = phoneParam;
    }


}
