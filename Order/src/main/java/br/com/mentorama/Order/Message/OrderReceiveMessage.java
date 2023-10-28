package br.com.mentorama.Order.Message;

import br.com.mentorama.Order.Convert.Convert;
import br.com.mentorama.Order.Dto.OrderDto;
import br.com.mentorama.Order.Entity.Order;
import br.com.mentorama.Order.RabbitConfig.OrderQueuesConfig;
import br.com.mentorama.Order.Service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderReceiveMessage {

    @Autowired
    private final OrderService orderService;
    @Autowired
    private final Convert convert;

    @RabbitListener(queues = OrderQueuesConfig.QUEUE_ORDER)
    public void receiveMessage(@Payload OrderDto orderDto){
        log.info(orderDto.toString());
        Order order = convert.convertOrderDtoToClass(orderDto);
        orderService.insertOrder(order);
    }
}
