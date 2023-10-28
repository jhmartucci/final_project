package br.com.mentorama.Suppliers.Message;

import br.com.mentorama.Suppliers.Convert.Convert;
import br.com.mentorama.Suppliers.Dto.AddressSuppliersUpdateDto;
import br.com.mentorama.Suppliers.Entity.Address;
import br.com.mentorama.Suppliers.RabbitConfig.AddressUpdateQueuesConfig;
import br.com.mentorama.Suppliers.Service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class    AddressUpdateReceiveMessage {

    @Autowired
    private final AddressService addressService;
    @Autowired
    private final Convert convert;

    @RabbitListener(queues = AddressUpdateQueuesConfig.ADDRESS_UPDATE_QUEUE)
    public void receiveMessage(@Payload AddressSuppliersUpdateDto addressSuppliersUpdateDto){
        log.info(addressSuppliersUpdateDto.toString());
        Address address = convert.convertAddressUpdateDtoToClass(addressSuppliersUpdateDto);
        addressService.updateAddress(address);
    }
}
