package com.br.mentorama.BFF.Message.Stock;

import com.br.mentorama.BFF.Dto.Stock.StockDto;
import com.br.mentorama.BFF.RabbitConfig.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockSendMessage {

    private final String ROUTINKEY = "StockRoutinkey";
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(StockDto stockDto){
        rabbitTemplate.convertAndSend(RabbitConfig.STOCK_EXCHANGE, ROUTINKEY, stockDto);
    }
}
