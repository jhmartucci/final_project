package br.com.mentorama.stock.Message.Receive;

import br.com.mentorama.stock.Convert.Convert;
import br.com.mentorama.stock.Dto.StockDto;
import br.com.mentorama.stock.Entity.Stock;
import br.com.mentorama.stock.RabbitConfig.StockReceiveProductQueuesConfig;
import br.com.mentorama.stock.Service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class StockReceiveProductMessage {

    @Autowired
    private final StockService stockService;
    @Autowired
    private final Convert convert;

    @RabbitListener(queues = StockReceiveProductQueuesConfig.PRODUCTS_TO_STOCK_QUEUE)
    public void receiveMessage(@Payload StockDto stockDto){
        log.info(stockDto.toString());
        Stock stock = convert.convertStockDtoToClass(stockDto);
        stockService.insertStock(stock);
    }
}
