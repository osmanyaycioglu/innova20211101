package com.training.spring.restaurant.apis;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.error.micro.MSRestClientException;
import com.training.spring.restaurant.models.MenuRequest;
import com.training.spring.restaurant.models.MenuResponse;

@RequestMapping("/api/v1/restaurant/menu")
public interface IRestaurantManagementApi {

    @PostMapping("/get/price")
    MenuResponse getPrice(@Validated @RequestBody final MenuRequest menuRequestParam) throws MSRestClientException;
}
