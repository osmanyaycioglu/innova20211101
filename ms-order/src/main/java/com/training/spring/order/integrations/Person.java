package com.training.spring.order.integrations;

public class Person {

    private String  phone;
    private String  name;
    private String  surname;
    private Integer height;
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


    public String getPhone() {
        return this.phone;
    }


    public Person setPhone(final String phoneParam) {
        this.phone = phoneParam;
        return this;
    }


}
