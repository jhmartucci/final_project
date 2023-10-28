package com.br.mentorama.BFF.RabbitConfig;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public final static String CUSTOMER_EXCHANGE = "Customers";
    public final static String SUPPLIER_EXCHANGE = "Suppliers";
    public final static String PRODUCT_EXCHANGE = "Products";
    public final static String STOCK_EXCHANGE = "Stocks";
    public final static String ORDER_EXCHANGE = "Orders";


    @Bean
    public DirectExchange directExchangeCustomer(){
        return new DirectExchange(CUSTOMER_EXCHANGE);
    }
    @Bean
    public DirectExchange directExchangeSupplier(){
        return new DirectExchange(SUPPLIER_EXCHANGE);
    }
    @Bean
    public DirectExchange directProducts(){
        return new DirectExchange(PRODUCT_EXCHANGE);
    }
    @Bean
    public DirectExchange directStocks(){
        return new DirectExchange(STOCK_EXCHANGE);
    }
    @Bean
    public DirectExchange directOrders(){
        return new DirectExchange(ORDER_EXCHANGE);
    }


    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }
    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListenerCustomer
            (RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    public RabbitTemplate rabbitTemplateCustomer(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter converter){
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
