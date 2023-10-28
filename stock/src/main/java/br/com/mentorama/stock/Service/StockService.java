package br.com.mentorama.stock.Service;

import br.com.mentorama.stock.Dto.StockOrderDto;
import br.com.mentorama.stock.Entity.Stock;
import br.com.mentorama.stock.Message.Send.StockOrderSendMessage;
import br.com.mentorama.stock.Repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockService {

    @Autowired
    private final StockRepository stockRepository;
    @Autowired
    private final StockOrderSendMessage stockOrderSendMessage;

    public Stock insertStock(Stock stock){
        stockRepository.save(stock);
        var stockOrderDto = new StockOrderDto(stock.getId(),stock.getProductId(),stock.getDescription(),stock.getQuantity());
        log.info(stockOrderDto.toString());
        stockOrderSendMessage.sendMessage(stockOrderDto);
        return stock;
    }
    public Stock updateStock(Stock stock){
        Optional<Stock> stockOptional = stockRepository.findById(stock.getId());

        return stockOptional.isPresent()?
                stockRepository.save(stock):
                null;
    }
    public boolean deleteStock(UUID id){
        Optional<Stock> stock = stockRepository.findById(id);
        if (stock.isPresent()){
            stockRepository.delete(stock.get());
            return true;
        }else{
            return false;
        }
    }
    public Optional<Stock> findByIdStock(UUID id){
        return stockRepository.findById(id);
    }
}
