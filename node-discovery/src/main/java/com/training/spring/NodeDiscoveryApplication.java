package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@EnableEurekaServer
public class NodeDiscoveryApplication {

    @Scheduled(fixedDelay = 10_000)
    public void name() {
    }

    public static void main(final String[] args) {
        SpringApplication.run(NodeDiscoveryApplication.class,
                              args);
    }

}
