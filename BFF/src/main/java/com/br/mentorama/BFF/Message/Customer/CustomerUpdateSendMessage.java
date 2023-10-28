package com.br.mentorama.BFF.Message.Customer;

import com.br.mentorama.BFF.Dto.Customer.CustomerUpdateDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerUpdateSendMessage {


    private final String ROUTINKEY ="CustomerUpdate.Routinkey";

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(CustomerUpdateDto customerUpdateDto){
        rabbitTemplate.convertAndSend(RabbitConfig.CUSTOMER_EXCHANGE,ROUTINKEY,customerUpdateDto);
    }
}
