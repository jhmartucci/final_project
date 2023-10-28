package br.com.mentorama.Suppliers.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressUpdateQueuesConfig {

    private final String ADDRESS_UPDATE_EXCHANGE = "Suppliers";
    public final static String ADDRESS_UPDATE_QUEUE = "AddressSuppliersUpdate.Queue";

    private final String ROUTINKEY = "AddressSuppliersUpdate.Routinkey";

    @Bean
    public Queue queueNameAddressUpdate(){
        return new Queue(ADDRESS_UPDATE_QUEUE);
    }
    @Bean
    public Binding bindingAddressUpdate(){
        var queue = new Queue(ADDRESS_UPDATE_QUEUE);
        var exchange = new DirectExchange(ADDRESS_UPDATE_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
