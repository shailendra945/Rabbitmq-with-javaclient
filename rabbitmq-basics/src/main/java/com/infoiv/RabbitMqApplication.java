package com.infoiv;

import com.infoiv.rabbimq.consumer.MessageConsumerHelper;
import com.infoiv.rabbitmq.client.publish.RabbitMqPublisherClient;

public class RabbitMqApplication {

    public static void main(String[] args) {

       String message = "first queued message";
        RabbitMqPublisherClient rabbitMqPublisherClient = new RabbitMqPublisherClient();
        rabbitMqPublisherClient.publish(message);
        System.out.println("---- Message published! ----");
        MessageConsumerHelper messageConsumerHelper = new MessageConsumerHelper();
        messageConsumerHelper.consumeMessage();
        System.out.println("---- Message consumed! ----");
    }
}