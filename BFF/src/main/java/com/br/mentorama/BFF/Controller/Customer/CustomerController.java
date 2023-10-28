package com.br.mentorama.BFF.Controller.Customer;

import com.br.mentorama.BFF.Dto.Customer.CustomerDto;
import com.br.mentorama.BFF.Dto.IdDto;
import com.br.mentorama.BFF.Dto.Customer.CustomerUpdateDto;
import com.br.mentorama.BFF.Message.Customer.CustomerDeleteSendMessage;
import com.br.mentorama.BFF.Message.Customer.CustomerSendMessage;
import com.br.mentorama.BFF.Message.Customer.CustomerUpdateSendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bff/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    @Autowired
    private final CustomerSendMessage customerSendMessage;
    @Autowired
    private final CustomerUpdateSendMessage customerUpdateSendMessage;
    @Autowired
    private final CustomerDeleteSendMessage deleteSendMessage;


    @PostMapping("/create")
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto){
        log.info(customerDto.toString());
        customerSendMessage.sendMessage(customerDto);
        return new ResponseEntity(customerDto, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable("id")UUID id, @RequestBody CustomerUpdateDto customerUpdateDto){
        customerUpdateDto.setId(id);
        log.info(customerUpdateDto.toString());
        customerUpdateSendMessage.sendMessage(customerUpdateDto);
        return new ResponseEntity<>(customerUpdateDto, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") UUID id){
        var idDto = new IdDto(id);
        log.info(idDto.toString());
        deleteSendMessage.sendMessage(idDto);
        return new ResponseEntity(HttpStatus.OK);
    }


}
