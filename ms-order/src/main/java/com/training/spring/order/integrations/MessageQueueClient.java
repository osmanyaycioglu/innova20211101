package com.training.spring.order.integrations;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageQueueClient {

    @Autowired
    private RabbitTemplate rt;

    public void sendSMS(final NotifyObj notifyObjParam,
                        final String extraRoute) {
        this.rt.convertAndSend("notfication-topic-exchange",
                               "message.sms." + extraRoute,
                               notifyObjParam);
    }

    public void sendMAIL(final NotifyObj notifyObjParam,
                         final String extraRoute) {
        this.rt.convertAndSend("notfication-topic-exchange",
                               "message.mail." + extraRoute,
                               notifyObjParam);
    }

}
