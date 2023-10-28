package br.com.mentorama.Suppliers.Message;

import br.com.mentorama.Suppliers.Convert.Convert;
import br.com.mentorama.Suppliers.Dto.SuppliersUpdateDto;
import br.com.mentorama.Suppliers.Entity.Suppliers;
import br.com.mentorama.Suppliers.RabbitConfig.SuppliersUpdateQueuesConfig;
import br.com.mentorama.Suppliers.Service.SuppliersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SuppliersUpdateReceiveMessage {

    @Autowired
    private final SuppliersService suppliersService;
    @Autowired
    private final Convert convert;

    @RabbitListener(queues = SuppliersUpdateQueuesConfig.QUEUE_UPDATE_SUPPLIERS)
    public void receiveMessage(@Payload SuppliersUpdateDto suppliersUpdateDto){
        log.info(suppliersUpdateDto.toString());
        Suppliers suppliers = convert.convertSuppliersUpdateDtoToClass(suppliersUpdateDto);
        suppliersService.updateSuppliers(suppliers);
    }
}
