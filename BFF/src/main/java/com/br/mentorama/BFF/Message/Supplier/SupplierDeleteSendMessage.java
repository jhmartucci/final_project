package com.br.mentorama.BFF.Message.Supplier;

import com.br.mentorama.BFF.Dto.IdDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierDeleteSendMessage {


    private final String ROUTINKEY= "SuppliersDelete.Routinkey";

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(IdDto idDto){
        rabbitTemplate.convertAndSend(RabbitConfig.SUPPLIER_EXCHANGE,ROUTINKEY,idDto);
    }
}
