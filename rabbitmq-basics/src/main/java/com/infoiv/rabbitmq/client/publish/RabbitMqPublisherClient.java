package com.infoiv.rabbitmq.client.publish;

import com.infoiv.connection.config.RabbitMqConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqPublisherClient {

    private String queueName = "GreetingMsgQueue";
    private String exchange  = "";
    private String routingKey = queueName;
    private Channel channel = null;
    private Connection connection;

    public RabbitMqPublisherClient(){
        try {
            connection = RabbitMqConnection.getConnection();
            channel = connection.createChannel();
            channel.queueDeclare(queueName,true,false,false,null);

        }
        catch (IOException  | TimeoutException ex){
            ex.printStackTrace();
        }
    }

    public void publish(String payload)  {

            try{

             channel.basicPublish(exchange,routingKey,null,payload.getBytes());
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
            finally {
                RabbitMqConnection.channelClose(channel);
                RabbitMqConnection.connectionClose();
            }


    }


}
