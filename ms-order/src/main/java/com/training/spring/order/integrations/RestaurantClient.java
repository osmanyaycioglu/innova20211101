package com.training.spring.order.integrations;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.error.micro.MSRestClientException;
import com.training.spring.order.integrations.clients.IRestaurantManagementClient;
import com.training.spring.restaurant.models.MenuRequest;
import com.training.spring.restaurant.models.MenuResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class RestaurantClient {

    @Autowired
    private IRestaurantManagementClient restaurantManagementClient;

    @CircuitBreaker(name = "mycircuitbr", fallbackMethod = "getPriceFallback")
    public MenuResponse getPrice(final MenuRequest menuRequestParam) throws MSRestClientException {
        return this.restaurantManagementClient.getPrice(menuRequestParam);
    }

    public MenuResponse getPriceFallback(final MenuRequest menuRequestParam,
                                         final Throwable th) {
        MenuResponse mr = new MenuResponse();
        mr.setPrice(BigDecimal.ONE);
        return mr;
    }


}
