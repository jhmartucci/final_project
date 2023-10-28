package br.com.mentorama.customers.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerDeleteQueuesConfig {
    private final String CUSTOMER_DELETE_EXCHANGE = "Customers";
    public final static String QUEUE_DELETE_CUSTOMER = "CustomersDelete.Queue";
    private final String ROUTINKEY ="CustomerDelete.Routinkey";
    @Bean
    public Queue queueNameCustomerDelete(){
        return new Queue(QUEUE_DELETE_CUSTOMER);
    }
    @Bean
    public Binding bindingCustomerDelete(){
        var queue = new Queue(QUEUE_DELETE_CUSTOMER);
        var exchange = new DirectExchange(CUSTOMER_DELETE_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
