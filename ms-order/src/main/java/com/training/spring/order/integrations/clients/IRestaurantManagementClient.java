package com.training.spring.order.integrations.clients;

import org.springframework.cloud.openfeign.FeignClient;

import com.training.spring.restaurant.apis.IRestaurantManagementApi;

@FeignClient("RESTAURANT")
public interface IRestaurantManagementClient extends IRestaurantManagementApi {

}
