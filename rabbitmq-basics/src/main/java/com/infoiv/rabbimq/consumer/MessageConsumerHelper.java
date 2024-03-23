package com.infoiv.rabbimq.consumer;

import com.infoiv.connection.config.RabbitMqConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class MessageConsumerHelper {

    private String queueName = "GreetingMsgQueue";
    private Channel channel = null;
    private Connection connection = null;

    public MessageConsumerHelper() {
        try{
            connection = RabbitMqConnection.getConnection();
            channel = connection.createChannel();
            channel.queueDeclare(queueName,true,false,false,null);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void consumeMessage(){
       MessageConsumer consumer = new MessageConsumer(channel);

       try {
           String consumerTag  = channel.basicConsume(queueName,true,consumer);
           channel.basicCancel(consumerTag);
       }
       catch (IOException ioEx){
          ioEx.printStackTrace();
       }
       finally {
           RabbitMqConnection.channelClose(channel);
           RabbitMqConnection.connectionClose();
       }


    }
}
