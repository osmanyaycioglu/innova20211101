package com.error.micro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MsErrorHandling {

    @Bean
    public RestErrorAdvice restErrorAdvice() {
        return new RestErrorAdvice();
    }

    @Bean
    public MsErrorDecoder msErrorDecoder() {
        return new MsErrorDecoder();
    }
}
