package com.br.mentorama.BFF.Message.Customer;

import com.br.mentorama.BFF.Dto.Customer.AddressCustomerDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressCustomerSendMessage {

    private final String ROUTINKEY ="AddressCustomerRoutinkey";

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(AddressCustomerDto addressCustomerDto){
        rabbitTemplate.convertAndSend(RabbitConfig.CUSTOMER_EXCHANGE,ROUTINKEY,addressCustomerDto);
    }
}
