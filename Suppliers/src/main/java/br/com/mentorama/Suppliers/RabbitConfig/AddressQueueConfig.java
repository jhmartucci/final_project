package br.com.mentorama.Suppliers.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressQueueConfig {

    private final String SUPPLIERS_EXCHANGE = "Suppliers";
    public final static String QUEUE_ADDRESS = "AddressSuppliers.Queue";
    private final String ROUTINKEY = "AddressSuppliersRoutinkey";

    @Bean
    public Queue queueNameAddress(){
        return new Queue(QUEUE_ADDRESS);
    }
    @Bean
    public Binding bindingAddress(){
        var queue = new Queue(QUEUE_ADDRESS);
        var exchange = new DirectExchange(SUPPLIERS_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
