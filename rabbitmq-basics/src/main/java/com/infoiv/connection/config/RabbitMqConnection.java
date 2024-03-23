package com.infoiv.connection.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqConnection {

    private static ConnectionFactory factory =  new ConnectionFactory();
    private static Connection connection = null;



    private RabbitMqConnection(){
        //this property should be externalize
        try {
            factory.setUri("amqp://guest:guest@localhost:5672/vhost");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //factory.setHost("localhost");
        //factory.setUsername("guest");
        //factory.setPassword("guest");
    }

    public static Connection getConnection() throws IOException, TimeoutException {
        connection = factory.newConnection();
        return connection;
    }
    public static void channelClose(Channel channel){
        if(channel !=null){
            try{
                channel.close();
            }
            catch (IOException | TimeoutException ex){
                ex.printStackTrace();
            }

        }
    }

    public static void connectionClose(){
        if(connection != null){
            try {
                connection.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }


}
