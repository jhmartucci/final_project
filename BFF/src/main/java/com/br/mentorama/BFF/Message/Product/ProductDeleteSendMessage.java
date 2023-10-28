package com.br.mentorama.BFF.Message.Product;

import com.br.mentorama.BFF.Dto.IdDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDeleteSendMessage {

    private final String ROUTINKEY = "ProductsDelete.Routinkey";
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(IdDto idDto){
        rabbitTemplate.convertAndSend(RabbitConfig.PRODUCT_EXCHANGE, ROUTINKEY, idDto);
    }
}
