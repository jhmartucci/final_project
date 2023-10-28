package br.com.mentorama.Order.Message;

import br.com.mentorama.Order.Dto.StockDto;
import br.com.mentorama.Order.Entity.Stock;
import br.com.mentorama.Order.RabbitConfig.OrderReceiveStockQueuesConfig;
import br.com.mentorama.Order.Repositiry.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderReceiveStockMessage {

    @Autowired
    public final StockRepository stockRepository;

    @RabbitListener(queues = OrderReceiveStockQueuesConfig.ORDER_RECEIVE_STOCK_QUEUE)
    public void receiveMessage(StockDto stockDto){
        log.info(stockDto.toString());
        var stock = new Stock(null,
                stockDto.getStockId(),
                stockDto.getProductId(),
                stockDto.getDescription(),
                stockDto.getQuantity());
        stockRepository.save(stock);
    }
}
