package com.training.spring.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.order.integrations.Person;
import com.training.spring.order.integrations.PersonClient;
import com.training.spring.order.rest.Order;

@Service
public class OrderManagement {

    @Autowired
    private PersonClient personClient;

    public String placeOrder(final Order orderParam) {
        this.personClient.activatePerson(new Person().setName(orderParam.getName())
                                                     .setPhone(orderParam.getPhone())
                                                     .setSurname(orderParam.getSurname()));
        return "Siparişiniz 100 TL tutu sayın " + orderParam.getName();
    }

}
