package br.com.mentorama.Order.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderQueuesConfig {
    private final String ORDER_EXCHANGE = "Orders";
    public final static String  QUEUE_ORDER = "Order.Queue";
    private final String ROUTINKEY = "OrderRoutinkey";

    @Bean
    public Queue queueNameOrder(){
        return new Queue(QUEUE_ORDER);
    }
    @Bean
    public Binding bindingOrder(){
        var queue = new Queue(QUEUE_ORDER);
        var exchange = new DirectExchange(ORDER_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
