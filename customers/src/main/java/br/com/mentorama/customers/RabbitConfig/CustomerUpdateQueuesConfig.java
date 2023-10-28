package br.com.mentorama.customers.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerUpdateQueuesConfig {
    private final String CUSTOMER_UPDATE_EXCHANGE = "Customers";
    public final static String QUEUE_UPDATE_CUSTOMER = "CustomersUpdate.Queue";
    private final String ROUTINKEY ="CustomerUpdate.Routinkey";
    @Bean
    public Queue queueNameCustomerUpdate(){
        return new Queue(QUEUE_UPDATE_CUSTOMER);
    }
    @Bean
    public Binding bindingCustomerUpdate(){
        var queue = new Queue(QUEUE_UPDATE_CUSTOMER);
        var exchange = new DirectExchange(CUSTOMER_UPDATE_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
