package com.training.spring.order.integrations.clients;

import org.springframework.cloud.openfeign.FeignClient;

import com.training.spring.restaurant.apis.IRestaurantManagementApi;

@FeignClient(name = "RESTAURANT-CONTEXT", contextId = "restaurant1")
public interface IRestaurantManagementClient extends IRestaurantManagementApi {

}
