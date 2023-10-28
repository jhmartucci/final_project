package com.br.mentorama.BFF;

import com.br.mentorama.BFF.Dto.Stock.StockDto;
import com.br.mentorama.BFF.Message.Stock.StockSendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bff/stock")
@RequiredArgsConstructor
@Slf4j
public class StockController {

    @Autowired
    private final StockSendMessage stockSendMessage;

    @PostMapping("/create")
    public ResponseEntity createStock(@RequestBody StockDto stockDto){
        log.info(stockDto.toString());
        stockSendMessage.sendMessage(stockDto);
        return new ResponseEntity<>(stockDto, HttpStatus.CREATED);
    }
}
