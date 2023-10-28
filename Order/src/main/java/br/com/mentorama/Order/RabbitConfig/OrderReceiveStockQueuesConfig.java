package br.com.mentorama.Order.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderReceiveStockQueuesConfig {

    private final String ORDER_RECEIVE_STOCK_EXCHANGE = "Orders";
    public final static String ORDER_RECEIVE_STOCK_QUEUE = "OrderReceiveStock.Queue";
    private final String ROUTINKEY = "OrderReceiveStock.Routinkey";

    @Bean
    public Queue queueNameOrderReceiveStock(){
        return new Queue(ORDER_RECEIVE_STOCK_QUEUE);
    }
    @Bean
    public Binding bindingOrderReceiveStock(){
        var queue = new Queue(ORDER_RECEIVE_STOCK_QUEUE);
        var exchange = new DirectExchange(ORDER_RECEIVE_STOCK_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }

}
