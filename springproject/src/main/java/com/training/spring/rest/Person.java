package com.training.spring.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.training.spring.validation.StartWith;

public class Person {

    @NotEmpty
    @Size(min = 4, max = 12, message = "username {min} ile {max} arasında olmalı.")
    private String  username;
    @NotEmpty
    @Size(min = 2, max = 20, message = "name {min} ile {max} arasında olmalı.")
    private String  name;
    @NotEmpty
    @Size(min = 2, max = 30, message = "surname {min} ile {max} arasında olmalı.")
    @StartWith("s:")
    private String  surname;
    @NotNull
    @Max(300)
    @Min(90)
    private Integer height;
    @NotNull
    @Max(250)
    @Min(10)
    private Integer weight;

    public String getName() {
        return this.name;
    }

    public Person setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public Person setSurname(final String surnameParam) {
        this.surname = surnameParam;
        return this;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Person setHeight(final Integer heightParam) {
        this.height = heightParam;
        return this;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public Person setWeight(final Integer weightParam) {
        this.weight = weightParam;
        return this;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", height="
               + this.height
               + ", weight="
               + this.weight
               + "]";
    }

    public String getUsername() {
        return this.username;
    }

    public Person setUsername(final String usernameParam) {
        this.username = usernameParam;
        return this;
    }


}
