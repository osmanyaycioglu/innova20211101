package com.training.spring.person.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.training.spring.person.models.EStatus;
import com.training.spring.person.models.PersonDto;

@Service
public class PersonDataStorage {

    private final Map<String, PersonDto> personStore = new ConcurrentHashMap<>();
    private final AtomicLong             counter     = new AtomicLong();

    public void addOrUpdate(final PersonDto dtoParam) {
        this.personStore.put(dtoParam.getUsername(),
                             dtoParam);
        this.counter.incrementAndGet();
    }

    public void deactivate(final String username) {
        PersonDto personDtoLoc = this.personStore.get(username);
        if (personDtoLoc != null) {
            personDtoLoc.setStatus(EStatus.PASSIVE);
        }
    }

    public void remove(final String username) {
        this.personStore.remove(username);
    }

    public PersonDto getSinglePerson(final String usernameParam) {
        return this.personStore.get(usernameParam);
    }

    public List<PersonDto> getAll() {
        return new ArrayList<>(this.personStore.values());
    }

    public List<PersonDto> getByName(final String nameParam) {
        return this.personStore.values()
                               .stream()
                               .filter(p -> p.getName()
                                             .equals(nameParam))
                               .collect(Collectors.toList());
    }

}
