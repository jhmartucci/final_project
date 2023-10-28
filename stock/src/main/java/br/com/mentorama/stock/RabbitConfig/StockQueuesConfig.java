package br.com.mentorama.stock.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockQueuesConfig {
    private final String STOCK_EXCHANGE = "Stocks";
    public final static String QUEUE_STOCK = "Stock.Queue";
    private final String ROUTINKEY = "StockRoutinkey";

    @Bean
    public Queue queueNameStock(){
        return new Queue(QUEUE_STOCK);
    }
    @Bean
    public Binding bindingStock(){
        var queue = new Queue(QUEUE_STOCK);
        var exchange = new DirectExchange(STOCK_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }

}
