package com.training.spring.order.integrations.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.spring.order.integrations.Person;


@FeignClient("PERSON")
@RequestMapping("/api/v1/person/provision")
public interface IPersonProvisionClient {

    @PostMapping("/activate")
    public String activate(@RequestBody final Person person);

}
