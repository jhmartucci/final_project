package br.com.mentorama.Suppliers.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SuppliersDeleteQueuesConfig {

    private final String SUPPLIERS_DELETE_EXCHANGE = "Suppliers";
    public final static String QUEUE_DELETE_SUPPLIERS = "SuppliersDelete.Queue";
    private final String ROUTINKEY= "SuppliersDelete.Routinkey";

    @Bean
    public Queue queueNameSuppliersDelete(){
        return new Queue(QUEUE_DELETE_SUPPLIERS);
    }
    @Bean
    public Binding bindingSuppliersDelete(){
        var queue = new Queue(QUEUE_DELETE_SUPPLIERS);
        var exchange = new DirectExchange(SUPPLIERS_DELETE_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }

}
