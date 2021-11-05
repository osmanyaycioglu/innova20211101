package com.training.spring.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.error.micro.MSRestClientException;
import com.training.spring.order.integrations.MessageQueueClient;
import com.training.spring.order.integrations.NotifyObj;
import com.training.spring.order.integrations.Person;
import com.training.spring.order.integrations.PersonClient;
import com.training.spring.order.integrations.RestaurantClient;
import com.training.spring.order.rest.Order;
import com.training.spring.restaurant.models.MenuRequest;
import com.training.spring.restaurant.models.MenuResponse;

@Service
public class OrderManagement {

    @Autowired
    private PersonClient       personClient;

    @Autowired
    private RestaurantClient   restaurantClient;

    @Autowired
    private MessageQueueClient messageQueueClient;

    public String placeOrder(final Order orderParam) throws MSRestClientException {
        this.personClient.activatePerson(new Person().setName(orderParam.getName())
                                                     .setPhone(orderParam.getPhone())
                                                     .setSurname(orderParam.getSurname()));
        MenuRequest menuRequestLoc = new MenuRequest();
        menuRequestLoc.setMeals(orderParam.getMeals());
        menuRequestLoc.setPhone(orderParam.getPhone());
        MenuResponse priceLoc = this.restaurantClient.getPrice(menuRequestLoc);
        String stringLoc = "Siparişiniz " + priceLoc.getPrice() + " TL tutu sayın " + orderParam.getName();
        NotifyObj notifyObjLoc = new NotifyObj();
        notifyObjLoc.setDest("23784682374");
        notifyObjLoc.setMessage(stringLoc);
        this.messageQueueClient.sendSMS(notifyObjLoc,
                                        stringLoc);
        NotifyObj notifyObjLoc2 = new NotifyObj();
        notifyObjLoc.setDest("os@os.com");
        notifyObjLoc.setMessage(stringLoc);
        this.messageQueueClient.sendMAIL(notifyObjLoc2,
                                         stringLoc);
        return stringLoc;
    }

}
