package br.com.mentorama.product.RabbitConfig;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUpdateQueuesConfig {

    private final String PRODUCT_EXCHANGE = "Products";
    public final static String QUEUE_UPDATE_PRODUCTS = "ProductUpdate.Queue";
    private final String ROUTINKEY = "ProductUpdate.Routinkey";

    @Bean
    public Queue queueNameProductUpdate(){
        return new Queue(QUEUE_UPDATE_PRODUCTS);
    }
    @Bean
    public Binding bindingProductUpdate(){
        var queue = new Queue(QUEUE_UPDATE_PRODUCTS);
        var exchange = new DirectExchange(PRODUCT_EXCHANGE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINKEY);
    }
}
