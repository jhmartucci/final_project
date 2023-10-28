package br.com.mentorama.Suppliers.Message;

import br.com.mentorama.Suppliers.Dto.IdDto;
import br.com.mentorama.Suppliers.RabbitConfig.SuppliersDeleteQueuesConfig;
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
public class SuppliersDeleteReceiveMessage {

    @Autowired
    private final SuppliersService suppliersService;

    @RabbitListener(queues = SuppliersDeleteQueuesConfig.QUEUE_DELETE_SUPPLIERS)
    public void receiveMessage(@Payload IdDto idDto){
        log.info(idDto.toString());
        suppliersService.deleteSuppliers(idDto.getId());
    }
}
