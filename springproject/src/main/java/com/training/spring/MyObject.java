package com.training.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Scope("prototype")
public class MyObject {

    private int    counter;

    @Value("${app.deneme.tst}")
    private String name;

    public void hello() {
        System.out.println("hello world " + this.name + " " + this.counter++);
    }

}
