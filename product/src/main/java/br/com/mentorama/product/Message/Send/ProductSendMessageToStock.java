package br.com.mentorama.product.Message.Send;

import br.com.mentorama.product.Dto.StockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ProductSendMessageToStock {

    private final String EXCHANGE = "Stocks";
    private final String ROUTINKEY = "ProductToStock.Routinkey";
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(StockDto stockDto){
        rabbitTemplate.convertAndSend(EXCHANGE,ROUTINKEY,stockDto);
    }

}
