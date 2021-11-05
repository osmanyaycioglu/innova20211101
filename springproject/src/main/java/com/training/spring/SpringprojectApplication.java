package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.error.micro.MsErrorHandling;

@SpringBootApplication
//@Controller
//@Repository
//@Service
//@Configuration
@Import(MsErrorHandling.class)
public class SpringprojectApplication {

    @Autowired
    @Qualifier("myObject")
    private MyObject myObjectLoc1;
    @Autowired
    @Qualifier("myObject")
    private MyObject myObjectLoc2;
    @Autowired
    @Qualifier("createMyObject")
    private MyObject myObjectLoc3;
    @Autowired
    @Qualifier("createMyObject")
    private MyObject myObjectLoc4;

    public void sayHello() {
        this.myObjectLoc1.hello();
        this.myObjectLoc2.hello();
        this.myObjectLoc3.hello();
        this.myObjectLoc4.hello();
    }

    public static void main(final String[] args) {
        ConfigurableApplicationContext runLoc = SpringApplication.run(SpringprojectApplication.class,
                                                                      args);

        SpringprojectApplication beanLoc = runLoc.getBean(SpringprojectApplication.class);
        beanLoc.sayHello();


    }

}
