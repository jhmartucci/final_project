package br.com.mentorama.stock.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockReceiveProductQueuesConfig {

    private final String PRODUCTS_TO_STOCK_EXCHANGE = "Stocks";
    public final static String PRODUCTS_TO_STOCK_QUEUE = "ProductsToStock.Queue";
    private final String ROUTINKEY = "ProductToStock.Routinkey";

    @Bean
    public Queue queueNameProductsToStock(){
        return new Queue(PRODUCTS_TO_STOCK_QUEUE);
    }
    @Bean
    public Binding bindingProductsToStock(){
        var queue = new Queue(PRODUCTS_TO_STOCK_QUEUE);
        var exchange = new DirectExchange(PRODUCTS_TO_STOCK_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
