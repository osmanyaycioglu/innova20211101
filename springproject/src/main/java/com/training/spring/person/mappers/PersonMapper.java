package com.training.spring.person.mappers;

import java.util.ArrayList;
import java.util.List;

import com.training.spring.person.models.EStatus;
import com.training.spring.person.models.PersonDto;
import com.training.spring.rest.Person;

public class PersonMapper {

    public static PersonDto toInternalPerson(final Person person) {
        return new PersonDto().setPhone(person.getPhone())
                              .setName(person.getName())
                              .setSurname(person.getSurname())
                              .setHeight(person.getHeight())
                              .setWeight(person.getWeight())
                              .setStatus(EStatus.ACTIVE);
    }

    public static Person toExternalPerson(final PersonDto person) {
        if (person == null) {
            return null;
        }
        return new Person().setPhone(person.getPhone())
                           .setName(person.getName())
                           .setSurname(person.getSurname())
                           .setHeight(person.getHeight())
                           .setWeight(person.getWeight());
    }

    public static List<Person> toExternalPersons(final List<PersonDto> allParam) {
        List<Person> personsLoc = new ArrayList<>();
        for (PersonDto personDtoLoc : allParam) {
            personsLoc.add(toExternalPerson(personDtoLoc));
        }
        return personsLoc;
    }

}
