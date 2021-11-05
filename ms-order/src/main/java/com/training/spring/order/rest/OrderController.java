package com.training.spring.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.error.micro.MSRestClientException;
import com.training.spring.order.services.OrderManagement;

@RestController
@RequestMapping("/api/v1/order/process")
public class OrderController {

    @Autowired
    private OrderManagement om;

    @PostMapping("/place")
    public String place(@RequestBody final Order order) throws MSRestClientException {
        return this.om.placeOrder(order);
    }

}
