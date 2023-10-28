package br.com.mentorama.customers.Message;

import br.com.mentorama.customers.Dto.IdDto;
import br.com.mentorama.customers.RabbitConfig.CustomerDeleteQueuesConfig;
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
public class CustomerDeleteReceiveMessage {

    @Autowired
    private final CustomerService customerService;

    @RabbitListener(queues = CustomerDeleteQueuesConfig.QUEUE_DELETE_CUSTOMER)
    public void receiveMessage(@Payload IdDto idDto){
        log.info(idDto.toString());
        customerService.deleteCustomer(idDto.getId());
    }

}
