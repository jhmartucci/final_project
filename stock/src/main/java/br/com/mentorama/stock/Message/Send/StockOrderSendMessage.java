package br.com.mentorama.stock.Message.Send;

import br.com.mentorama.stock.Dto.StockOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StockOrderSendMessage {

    private final String EXCHANGE = "Orders";
    private final String ROUTINKEY = "OrderReceiveStock.Routinkey";
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(StockOrderDto stockOrderDto){
        rabbitTemplate.convertAndSend(EXCHANGE,ROUTINKEY,stockOrderDto);
    }
}
