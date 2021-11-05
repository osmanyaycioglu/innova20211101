package com.training.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-queue", durable = "true", autoDelete = "false"),
                                             exchange = @Exchange(name = "notfication-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "sms-notification"))
    public void handleSMSMessage(final NotifyObj str) {
        System.out.println("Recieved SMS : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "mail-queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notfication-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "mail-notification"))
    public void handleMailMessage(final NotifyObj str) {
        System.out.println("Recieved MAIL : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "mail-ex-queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notfication-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "message.mail.#"))
    public void handleMAILExMessage(final NotifyObj str) {
        System.out.println("Recieved MAIL : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "all-ex-queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notfication-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "message.#"))
    public void handleAllExMessage(final NotifyObj str) {
        System.out.println("Recieved ALL : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-ex-queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notfication-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "message.sms.#"))
    public void handleSMSExMessage(final NotifyObj str) {
        System.out.println("Recieved SMS : " + str);
    }


}
