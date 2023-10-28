package br.com.mentorama.Suppliers.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressDeleteQueueConfig {

    private final String ADDRESS_DELETE_EXCHANGE = "Suppliers";
    public final static String ADDRESS_DELETE_QUEUE = "AddressSuppliersDelete.Queue";
    private final String ROUTINKEY = "AddressSuppliersDelete.Routinkey";

    @Bean
    public Queue queueNameAddressDelete(){
        return new Queue(ADDRESS_DELETE_QUEUE);
    }
    @Bean
    public Binding bindingAddressDelete(){
        var queue = new Queue(ADDRESS_DELETE_QUEUE);
        var exchange = new DirectExchange(ADDRESS_DELETE_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
