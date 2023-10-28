package br.com.mentorama.customers.Message;

import br.com.mentorama.customers.Convert.Convert;
import br.com.mentorama.customers.Dto.CustomerDto;
import br.com.mentorama.customers.Dto.CustomerUpdateDto;
import br.com.mentorama.customers.Entity.Customer;
import br.com.mentorama.customers.RabbitConfig.CustomerQueuesConfig;
import br.com.mentorama.customers.RabbitConfig.CustomerUpdateQueuesConfig;
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
public class CustomerUpdateReceiveMessage {

    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final Convert convert;

    @RabbitListener(queues = CustomerUpdateQueuesConfig.QUEUE_UPDATE_CUSTOMER)
    public void receiveMessage(@Payload CustomerUpdateDto customerUpdateDto){
        log.info(customerUpdateDto.toString());
        Customer customer = convert.convertCustomerUpdateDtoToClass(customerUpdateDto);
        customerService.updateCustomer(customer);
    }

}
