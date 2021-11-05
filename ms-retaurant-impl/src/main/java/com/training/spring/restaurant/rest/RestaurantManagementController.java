package com.training.spring.restaurant.rest;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RestController;

import com.training.spring.restaurant.apis.IRestaurantManagementApi;
import com.training.spring.restaurant.models.MenuRequest;
import com.training.spring.restaurant.models.MenuResponse;

@RestController
public class RestaurantManagementController implements IRestaurantManagementApi {

    @Override
    public MenuResponse getPrice(final MenuRequest menuRequestParam) {
        MenuResponse menuResponseLoc = new MenuResponse();
        menuResponseLoc.setPrice(BigDecimal.valueOf(99.9D));
        return menuResponseLoc;
    }

}
