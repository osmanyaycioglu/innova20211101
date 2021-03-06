package com.training.spring.person.models;

public class PersonDto {

    private String  name;
    private String  surname;
    private String  phone;
    private Integer height;
    private Integer weight;
    private EStatus status;

    public String getName() {
        return this.name;
    }

    public PersonDto setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public PersonDto setSurname(final String surnameParam) {
        this.surname = surnameParam;
        return this;
    }

    public Integer getHeight() {
        return this.height;
    }

    public PersonDto setHeight(final Integer heightParam) {
        this.height = heightParam;
        return this;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public PersonDto setWeight(final Integer weightParam) {
        this.weight = weightParam;
        return this;
    }

    public EStatus getStatus() {
        return this.status;
    }

    public PersonDto setStatus(final EStatus statusParam) {
        this.status = statusParam;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public PersonDto setPhone(final String phoneParam) {
        this.phone = phoneParam;
        return this;
    }


}
