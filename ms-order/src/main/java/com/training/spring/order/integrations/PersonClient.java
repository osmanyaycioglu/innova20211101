package com.training.spring.order.integrations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.spring.order.integrations.clients.IPersonProvisionClient;

@Service
public class PersonClient {

    @Autowired
    private RestTemplate  rt;

    @Autowired
    private EurekaClient  eurekaClient;

    @Autowired
    private IPersonProvisionClient personProvisionClient;

    public Person getPerson(final String phoneParam) {
        Person personLoc = this.rt.getForObject("http://PERSON/api/v1/person/query/get/single/" + phoneParam,
                                                Person.class);
        return personLoc;
    }

    public String activatePerson(final Person person) {
        return this.personProvisionClient.activate(person);
    }

    public String activatePerson3(final Person person) {
        return this.rt.postForObject("http://PERSON/api/v1/person/provision/activate",
                                     person,
                                     String.class);
    }

    public String activatePerson2(final Person person) {
        RestTemplate rt2 = new RestTemplate();
        Application applicationLoc = this.eurekaClient.getApplication("PERSON");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc);
        }
        InstanceInfo instanceInfoLoc = instancesLoc.get(0);
        return rt2.postForObject("http://"
                                 + instanceInfoLoc.getIPAddr()
                                 + ":"
                                 + instanceInfoLoc.getPort()
                                 + "/api/v1/person/provision/activate",
                                 person,
                                 String.class);
    }

}
