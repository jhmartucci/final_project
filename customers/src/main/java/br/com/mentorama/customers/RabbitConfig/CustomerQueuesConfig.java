package br.com.mentorama.customers.RabbitConfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerQueuesConfig {
    private final String CUSTOMER_EXCHANGE = "Customers";
    public final static String QUEUE_CUSTOMER = "Customers.Queue";
    private final String  ROUTINKEY= "CustomerRoutinkey";
    @Bean
    public Queue queueNameCustomer(){
        return new Queue(QUEUE_CUSTOMER);
    }
    @Bean
    public Binding bindingCustomer(){
        var queue = new Queue(QUEUE_CUSTOMER);
        var exchange = new DirectExchange(CUSTOMER_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
