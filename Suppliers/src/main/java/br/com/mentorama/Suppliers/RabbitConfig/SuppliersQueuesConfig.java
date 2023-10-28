package br.com.mentorama.Suppliers.RabbitConfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SuppliersQueuesConfig {

    private final String SUPPLIERS_EXCHANGE = "Suppliers";
    public final static String QUEUE_SUPPLIERS = "Suppliers.Queue";
    private final String ROUTINKEY= "SuppliersRoutinkey";

    @Bean
    public Queue queueNameSuppliers(){
        return new Queue(QUEUE_SUPPLIERS);
    }
    @Bean
    public Binding bindingSuppliers(){
        var queue = new Queue(QUEUE_SUPPLIERS);
        var exchange = new DirectExchange(SUPPLIERS_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }

}
