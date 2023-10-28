package br.com.mentorama.stock.Controller;

import br.com.mentorama.stock.Convert.Convert;
import br.com.mentorama.stock.Dto.StockDto;
import br.com.mentorama.stock.Entity.Stock;
import br.com.mentorama.stock.Service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    @Autowired
    private final StockService stockService;
    @Autowired
    private final Convert convert;

    @PostMapping("/create")
    public ResponseEntity insertStock(@RequestBody StockDto stockDto){
        try {
            Stock stock = stockService.insertStock(convert.convertStockDtoToClass(stockDto));
            return new ResponseEntity<>(stock, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStock(@PathVariable("id") UUID id, @RequestBody StockDto stockDto){
        Stock stock = convert.convertStockDtoToClass(stockDto);
        stock.setId(id);
        Stock upStock = stockService.updateStock(stock);

        return Objects.nonNull(upStock)?
                new ResponseEntity<>(stock,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("find/{id}")
    public ResponseEntity findByIdStock(@PathVariable UUID id){
        Optional<Stock> stock = stockService.findByIdStock(id);

        return stock.isPresent()?
                new ResponseEntity(stock, HttpStatus.OK):
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStock(@PathVariable("id") UUID id){
        return stockService.deleteStock(id)?
                new ResponseEntity(HttpStatus.OK):
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
