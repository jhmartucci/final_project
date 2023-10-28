package com.br.mentorama.BFF.Message.Supplier;

import com.br.mentorama.BFF.Dto.Supplier.AddressSuppliersDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressSuplliersSendMessage {

    private final String ROUTINKEY = "AddressSuppliersRoutinkey";
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(AddressSuppliersDto addressSuppliersDto){
        rabbitTemplate.convertAndSend(RabbitConfig.SUPPLIER_EXCHANGE, ROUTINKEY, addressSuppliersDto);
    }
}
