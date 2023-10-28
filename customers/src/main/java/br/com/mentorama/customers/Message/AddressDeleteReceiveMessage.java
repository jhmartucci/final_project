package br.com.mentorama.customers.Message;

import br.com.mentorama.customers.Dto.IdDto;
import br.com.mentorama.customers.RabbitConfig.AddressDeleteQueuesConfig;
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
public class AddressDeleteReceiveMessage {

    @Autowired
    private final AddressService addressService;

    @RabbitListener(queues = AddressDeleteQueuesConfig.ADDRESS_QUEUE_DELETE_CUSTOMER)
    public void receiveMessage(@Payload IdDto idDto){
        log.info(idDto.toString());
        addressService.deleteAddress(idDto.getId());
    }

}
