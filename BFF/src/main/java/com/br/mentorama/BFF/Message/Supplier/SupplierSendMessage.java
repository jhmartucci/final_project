package com.br.mentorama.BFF.Message.Supplier;

import com.br.mentorama.BFF.Dto.Supplier.SuppliersDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierSendMessage {

    private final String ROUTINKEY ="SuppliersRoutinkey";

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(SuppliersDto suppliersDto){
        rabbitTemplate.convertAndSend(RabbitConfig.SUPPLIER_EXCHANGE,ROUTINKEY,suppliersDto);
    }
}
