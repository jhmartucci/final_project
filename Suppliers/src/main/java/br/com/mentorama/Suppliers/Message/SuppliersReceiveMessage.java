package br.com.mentorama.Suppliers.Message;

import br.com.mentorama.Suppliers.Convert.Convert;
import br.com.mentorama.Suppliers.Dto.SuppliersDto;
import br.com.mentorama.Suppliers.Entity.Suppliers;
import br.com.mentorama.Suppliers.RabbitConfig.SuppliersQueuesConfig;
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
public class SuppliersReceiveMessage {

    @Autowired
    private final SuppliersService suppliersService;
    @Autowired
    private final Convert convert;

    @RabbitListener(queues = SuppliersQueuesConfig.QUEUE_SUPPLIERS)
    public void receiveMessage(@Payload SuppliersDto suppliersDto){
        log.info(suppliersDto.toString());
        Suppliers suppliers = convert.convertSuppliersDtoToClass(suppliersDto);
        suppliersService.insertSuppliers(suppliers);
    }
}
