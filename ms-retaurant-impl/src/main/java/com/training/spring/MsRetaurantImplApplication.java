package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

import com.error.micro.MsErrorHandling;

@SpringBootApplication
@EnableEurekaClient
@Import(MsErrorHandling.class)
public class MsRetaurantImplApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsRetaurantImplApplication.class,
                              args);
    }

}
