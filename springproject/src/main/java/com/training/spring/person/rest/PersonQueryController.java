package com.training.spring.person.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.rest.Person;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQueryController {

    @GetMapping("/get/single/{username}")
    public Person getSingle(@PathVariable("username") final String username) {
        return null;
    }

    @GetMapping("/get/all")
    public List<Person> getAll() {
        return null;
    }

    @GetMapping("/get/by/name")
    public List<Person> getByName(@RequestParam("name") final String name) {
        return null;
    }

}
