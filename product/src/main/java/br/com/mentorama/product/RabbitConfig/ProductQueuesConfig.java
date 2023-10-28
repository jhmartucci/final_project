package br.com.mentorama.product.RabbitConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductQueuesConfig {

    private final String PRODUCT_EXCHANGE = "Products";
    public final  static String QUEUE_PRODUCTS = "Product.Queue";
    private final String ROUTINKEY = "ProductRoutinkey";

    @Bean
    public Queue queueNameProduct(){
        return new Queue(QUEUE_PRODUCTS);
    }
    @Bean
    public Binding bindingProduct(){
        var queue = new Queue(QUEUE_PRODUCTS);
        var exchange = new DirectExchange(PRODUCT_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
