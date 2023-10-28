package com.br.mentorama.BFF.Message.Order;

import com.br.mentorama.BFF.Dto.Order.OrderDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderSendMessage {

    private final String ROUTINKEY = "OrderRoutinkey";
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(OrderDto orderDto){
        log.info(orderDto.toString());
        rabbitTemplate.convertAndSend(RabbitConfig.ORDER_EXCHANGE, ROUTINKEY, orderDto);
    }

}
