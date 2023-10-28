package br.com.mentorama.Suppliers.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SuppliersUpdateQueuesConfig {

    private final String SUPPLIERS_UPDATE_EXCHANGE = "Suppliers";
    public final static String QUEUE_UPDATE_SUPPLIERS = "SuppliersUpdate.Queue";
    private final String ROUTINKEY= "SuppliersUpdate.Routinkey";

    @Bean
    public Queue queueNameSuppliersUpdate(){
        return new Queue(QUEUE_UPDATE_SUPPLIERS);
    }
    @Bean
    public Binding bindingSuppliersUpdate(){
        var queue = new Queue(QUEUE_UPDATE_SUPPLIERS);
        var exchange = new DirectExchange(SUPPLIERS_UPDATE_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }

}
