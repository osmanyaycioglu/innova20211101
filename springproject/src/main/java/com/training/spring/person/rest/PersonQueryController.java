package com.training.spring.person.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.mappers.PersonMapper;
import com.training.spring.person.services.PersonQueryService;
import com.training.spring.rest.Person;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQueryController {

    private static final Logger logger = LoggerFactory.getLogger(PersonQueryController.class);

    @Value("${server.port}")
    private int                 port;

    @Autowired
    private PersonQueryService  pqs;

    @GetMapping("/get/single/{phone}")
    public Person getSingle(@PathVariable("phone") final String phone) {
        if (PersonQueryController.logger.isInfoEnabled()) {
            PersonQueryController.logger.info("[PersonQueryController][getSingle]-> Query request Port : "
                                              + this.port
                                              + " phone : "
                                              + phone);
        }

        return PersonMapper.toExternalPerson(this.pqs.getSinglePerson(phone));
    }

    @GetMapping("/get/all")
    public List<Person> getAll() {
        return PersonMapper.toExternalPersons(this.pqs.getAll());
    }

    @GetMapping("/get/by/name")
    public List<Person> getByName(@RequestParam("name") final String name) {
        return PersonMapper.toExternalPersons(this.pqs.getByName(name));
    }

}
