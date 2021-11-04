package com.training.spring.person.rest;

import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.mappers.PersonMapper;
import com.training.spring.person.services.PersonManagementService;
import com.training.spring.rest.Person;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1/person/provision")
@Validated
public class PersonProvisionController {

    private static final Logger     logger = LoggerFactory.getLogger(PersonProvisionController.class);

    @Value("${server.port}")
    private int                     port;

    @Autowired
    private PersonManagementService pms;

    @PostMapping("/activate")
    @ApiResponse(responseCode = "204", description = "bu description")
    @Operation(tags = {
                        "person",
                        "activate"
    }, description = "activate given Person")
    public String activate(@Validated @RequestBody final Person person) {
        if (PersonProvisionController.logger.isInfoEnabled()) {
            PersonProvisionController.logger.info("[PersonProvisionController][activate]-> Port : "
                                                  + this.port
                                                  + " activate request : "
                                                  + person);
        }
        this.pms.activate(PersonMapper.toInternalPerson(person));
        return "OK";
    }

    @PostMapping("/update")
    public String update(@RequestBody final Person person) {
        this.pms.update(PersonMapper.toInternalPerson(person));
        return "OK";
    }

    @GetMapping("/deactivate/{username}")
    public String update(@NotEmpty @PathVariable("username") final String username) {
        this.pms.deactivate(username);
        return "OK";
    }

}
