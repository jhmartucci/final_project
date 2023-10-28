package br.com.mentorama.Suppliers.Message;

import br.com.mentorama.Suppliers.Dto.IdDto;
import br.com.mentorama.Suppliers.RabbitConfig.AddressDeleteQueueConfig;
import br.com.mentorama.Suppliers.Service.AddressService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class AddressDelelteReceiveMessage {

    @Autowired
    private final AddressService addressService;

    @RabbitListener(queues = AddressDeleteQueueConfig.ADDRESS_DELETE_QUEUE)
    public void receiveMessage(IdDto idDto){
        log.info(idDto.toString());
        addressService.deleteAddress(idDto.getId());
    }
}
