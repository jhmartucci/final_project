package br.com.mentorama.stock.Convert;

import br.com.mentorama.stock.Dto.StockDto;
import br.com.mentorama.stock.Entity.Stock;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Convert {

    public Stock convertStockDtoToClass(StockDto stockDto){
        return new ModelMapper().map(stockDto, Stock.class);
    }
}
