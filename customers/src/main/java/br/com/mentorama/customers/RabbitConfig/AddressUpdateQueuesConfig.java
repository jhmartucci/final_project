package br.com.mentorama.customers.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressUpdateQueuesConfig {
    private final String ADDRESS_UPDATE_EXCHANGE = "Customers";
    public final static String QUEUE_UPDATE_ADDRESS = "AddressCustomerUpdate.Queue";
    private final String ROUTINKEY ="AddressCustomerUpdate.Routinkey";
    @Bean
    public Queue queueNameAddressUpdate(){
        return new Queue(QUEUE_UPDATE_ADDRESS);
    }
    @Bean
    public Binding bindingAddressUpdate(){
        var queue = new Queue(QUEUE_UPDATE_ADDRESS);
        var exchange = new DirectExchange(ADDRESS_UPDATE_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
