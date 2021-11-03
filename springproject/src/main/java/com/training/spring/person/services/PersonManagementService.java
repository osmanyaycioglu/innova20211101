package com.training.spring.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.person.data.PersonDataStorage;
import com.training.spring.person.models.EStatus;
import com.training.spring.person.models.PersonDto;

@Service
public class PersonManagementService {

    @Autowired
    private PersonDataStorage pds;

    public void activate(final PersonDto dtoParam) {
        this.pds.addOrUpdate(dtoParam);
        dtoParam.setStatus(EStatus.ACTIVE);
    }

    public void update(final PersonDto internalPersonParam) {
        this.pds.addOrUpdate(internalPersonParam);
    }

    public void deactivate(final String usernameParam) {
        this.pds.deactivate(usernameParam);
    }

}
