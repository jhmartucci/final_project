package br.com.mentorama.customers.Message;

import br.com.mentorama.customers.Dto.AddressDto;
import br.com.mentorama.customers.RabbitConfig.AddressQueuesConfig;
import br.com.mentorama.customers.Service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddressReceiveMessage {

    @Autowired
    private final AddressService addressService;

    @RabbitListener(queues = AddressQueuesConfig.QUEUE_ADDRESS)
    public void receiveMessage(@Payload AddressDto addressDto){
        log.info(addressDto.toString());
        addressService.insertAddress(addressDto);
    }

}
