package br.com.mentorama.customers.RabbitConfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressQueuesConfig {

    private final String CUSTOMER_EXCHANGE = "Customers";
    public final static String QUEUE_ADDRESS = "AdressCustomer.Queue";
    private final String  ROUTINKEY= "AddressCustomerRoutinkey";

    @Bean
    public Queue queueNameAddress(){
        return new Queue(QUEUE_ADDRESS);
    }
    @Bean
    public Binding bindingAddress(){
        var queue = new Queue(QUEUE_ADDRESS);
        var exchange = new DirectExchange(CUSTOMER_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }

}
