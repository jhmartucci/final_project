package com.br.mentorama.BFF.Message.Supplier;

import com.br.mentorama.BFF.Dto.Supplier.AddressSuppliersUpdateDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressSuppliersUpdateSendMessage {

    private final String ROUTINKEY = "AddressSuppliersUpdate.Routinkey";
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(AddressSuppliersUpdateDto addressSuppliersUpdateDto){
        rabbitTemplate.convertAndSend(RabbitConfig.SUPPLIER_EXCHANGE, ROUTINKEY, addressSuppliersUpdateDto);
    }

}
