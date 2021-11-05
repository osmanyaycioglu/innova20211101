package com.training.spring.order.integrations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.error.micro.MSRestClientException;
import com.training.spring.order.integrations.clients.IRestaurantManagementClient;
import com.training.spring.restaurant.models.MenuRequest;
import com.training.spring.restaurant.models.MenuResponse;

@Service
public class RestaurantClient {

    @Autowired
    private IRestaurantManagementClient restaurantManagementClient;

    public MenuResponse getPrice(final MenuRequest menuRequestParam) throws MSRestClientException {
        return this.restaurantManagementClient.getPrice(menuRequestParam);
    }

}
