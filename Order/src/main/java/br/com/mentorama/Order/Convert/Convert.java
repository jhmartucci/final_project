package br.com.mentorama.Order.Convert;

import br.com.mentorama.Order.Dto.OrderDto;
import br.com.mentorama.Order.Dto.StockDto;
import br.com.mentorama.Order.Entity.Order;
import br.com.mentorama.Order.Entity.Stock;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Convert {

    public Order convertOrderDtoToClass(OrderDto orderDto){
        return new ModelMapper().map(orderDto, Order.class);
    }
    public Stock convertStockDtoToClass(StockDto stockDto){
        return new ModelMapper().map(stockDto,Stock.class);
    }
}
