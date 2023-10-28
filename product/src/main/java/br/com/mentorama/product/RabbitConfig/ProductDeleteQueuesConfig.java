package br.com.mentorama.product.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductDeleteQueuesConfig {

    private final String PRODUCT_EXCHANGE = "Products";
    public final static String QUEUE_DELETE_PRODUCTS = "ProductsDelete.Queue";
    private final String ROUTINKEY = "ProductsDelete.Routinkey";

    @Bean
    public Queue queueNameProductsDelete(){
        return new Queue(QUEUE_DELETE_PRODUCTS);
    }
    @Bean
    public Binding bindingProductsDelete(){
        var queue = new Queue(QUEUE_DELETE_PRODUCTS);
        var exchange = new DirectExchange(PRODUCT_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
