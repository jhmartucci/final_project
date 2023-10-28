package com.br.mentorama.BFF.Message.Customer;

import com.br.mentorama.BFF.Dto.Customer.AddressCustomerUpdateDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressCustomerUpdateSendMessage {


    private final String ROUTINKEY ="AddressCustomerUpdate.Routinkey";

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(AddressCustomerUpdateDto addressCustomerUpdateDto){
        rabbitTemplate.convertAndSend(RabbitConfig.CUSTOMER_EXCHANGE,ROUTINKEY, addressCustomerUpdateDto);
    }
}
