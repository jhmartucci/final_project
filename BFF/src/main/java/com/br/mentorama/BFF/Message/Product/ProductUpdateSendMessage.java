package com.br.mentorama.BFF.Message.Product;

import com.br.mentorama.BFF.Dto.Product.ProductUpdateDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductUpdateSendMessage {

    private final String ROUTINKEY = "ProductUpdate.Routinkey";
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(ProductUpdateDto productUpdateDto){
        rabbitTemplate.convertAndSend(RabbitConfig.PRODUCT_EXCHANGE, ROUTINKEY, productUpdateDto);
    }
}
