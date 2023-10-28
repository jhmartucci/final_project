package br.com.mentorama.customers.Message;

import br.com.mentorama.customers.Convert.Convert;
import br.com.mentorama.customers.Dto.AddressUpdateDto;
import br.com.mentorama.customers.Dto.CustomerUpdateDto;
import br.com.mentorama.customers.Entity.Address;
import br.com.mentorama.customers.Entity.Customer;
import br.com.mentorama.customers.RabbitConfig.AddressUpdateQueuesConfig;
import br.com.mentorama.customers.RabbitConfig.CustomerUpdateQueuesConfig;
import br.com.mentorama.customers.Service.AddressService;
import br.com.mentorama.customers.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddressUpdateReceiveMessage {

    @Autowired
    private final AddressService addressService;
    @Autowired
    private final Convert convert;

    @RabbitListener(queues = AddressUpdateQueuesConfig.QUEUE_UPDATE_ADDRESS)
    public void receiveMessage(@Payload AddressUpdateDto addressUpdateDto){
        log.info(addressUpdateDto.toString());
        Address address = convert.convertAddresUpdateDtoToClass(addressUpdateDto);
        addressService.updateAddress(address);
    }

}
