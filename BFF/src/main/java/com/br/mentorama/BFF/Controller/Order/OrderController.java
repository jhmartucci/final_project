package com.br.mentorama.BFF.Controller.Order;

import com.br.mentorama.BFF.Dto.Order.OrderDto;
import com.br.mentorama.BFF.Message.Order.OrderSendMessage;
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
@RequestMapping("/bff/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    @Autowired
    private final OrderSendMessage orderSendMessage;

    @PostMapping("/create")
    public ResponseEntity createOrder(@RequestBody OrderDto orderDto){
        log.info(orderDto.toString());
        orderSendMessage.sendMessage(orderDto);
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }
}
