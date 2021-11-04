package com.training.spring.person.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.person.data.PersonDataStorage;
import com.training.spring.person.models.PersonDto;

@Service
public class PersonQueryService {

    @Autowired
    private PersonDataStorage pds;

    public PersonDto getSinglePerson(final String phone) {
        return this.pds.getSinglePerson(phone);
    }

    public List<PersonDto> getAll() {
        return this.pds.getAll();
    }

    public List<PersonDto> getByName(final String nameParam) {
        return this.pds.getByName(nameParam);
    }

}
