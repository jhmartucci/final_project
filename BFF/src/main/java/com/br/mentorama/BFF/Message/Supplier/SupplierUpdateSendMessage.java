package com.br.mentorama.BFF.Message.Supplier;

import com.br.mentorama.BFF.Dto.Supplier.SuppliersUpdateDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierUpdateSendMessage {


    private final String ROUTINKEY= "SuppliersUpdate.Routinkey";

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(SuppliersUpdateDto suppliersUpdateDto){
        rabbitTemplate.convertAndSend(RabbitConfig.SUPPLIER_EXCHANGE,ROUTINKEY,suppliersUpdateDto);
    }
}
