package com.br.mentorama.BFF.Message.Product;

import com.br.mentorama.BFF.Dto.Product.ProductDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductSendMessage {

    private final String ROUTINKEY = "ProductRoutinkey";
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(ProductDto productDto){
        rabbitTemplate.convertAndSend(RabbitConfig.PRODUCT_EXCHANGE, ROUTINKEY, productDto);
    }
}
