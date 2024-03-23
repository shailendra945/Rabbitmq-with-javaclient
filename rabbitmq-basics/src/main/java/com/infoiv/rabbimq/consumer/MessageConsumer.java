package com.infoiv.rabbimq.consumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class MessageConsumer extends DefaultConsumer {
    /**
     * Constructs a new instance and records its association to the passed-in channel.
     *
     * @param channel the channel to which this consumer is attached
     */
    public MessageConsumer(Channel channel) {
        super(channel);
    }

    @Override
    public void handleDelivery(
            String consumerTag,
            Envelope envelope,
            AMQP.BasicProperties properties,
            byte[] body) throws java.io.IOException {
        String message = new String(body);
        System.out.println("Message Received: " + message);
    }

}
