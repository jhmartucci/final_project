package br.com.mentorama.customers.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressDeleteQueuesConfig {
    private final String ADDRESS_CUSTOMER_DELETE_EXCHANGE = "Customers";
    public final static String ADDRESS_QUEUE_DELETE_CUSTOMER = "AddressCustomerDelete.Queue";
    private final String ROUTINKEY ="AddressCustomerDelete.Routinkey";
    @Bean
    public Queue queueNameAddressCustomerDelete(){
        return new Queue(ADDRESS_QUEUE_DELETE_CUSTOMER);
    }
    @Bean
    public Binding bindingAddressCustomerDelete(){
        var queue = new Queue(ADDRESS_QUEUE_DELETE_CUSTOMER);
        var exchange = new DirectExchange(ADDRESS_CUSTOMER_DELETE_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
