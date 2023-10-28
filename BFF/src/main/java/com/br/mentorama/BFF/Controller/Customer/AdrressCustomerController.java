package com.br.mentorama.BFF.Controller.Customer;

import com.br.mentorama.BFF.Dto.Customer.AddressCustomerDto;
import com.br.mentorama.BFF.Dto.Customer.AddressCustomerUpdateDto;
import com.br.mentorama.BFF.Dto.IdDto;
import com.br.mentorama.BFF.Message.Customer.AddressCustomerDeleteSendMessage;
import com.br.mentorama.BFF.Message.Customer.AddressCustomerSendMessage;
import com.br.mentorama.BFF.Message.Customer.AddressCustomerUpdateSendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bff/customer/address")
@RequiredArgsConstructor
@Slf4j
public class AdrressCustomerController {

    @Autowired
    private final AddressCustomerSendMessage sendMessage;
    @Autowired
    private final AddressCustomerUpdateSendMessage addressCustomerUpdateSendMessage;
    @Autowired
    private final AddressCustomerDeleteSendMessage addressCustomerDeleteSendMessage;

    @PostMapping("/create")
    public ResponseEntity createAddress(@RequestBody AddressCustomerDto addressCustomerDto){
        log.info(addressCustomerDto.toString());
        sendMessage.sendMessage(addressCustomerDto);
        return new ResponseEntity(addressCustomerDto, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@PathVariable("id")UUID id, @RequestBody AddressCustomerUpdateDto addressCustomerUpdateDto){
        addressCustomerUpdateDto.setId(id);
        log.info(addressCustomerUpdateDto.toString());
        addressCustomerUpdateSendMessage.sendMessage(addressCustomerUpdateDto);
        return new ResponseEntity<>(addressCustomerUpdateDto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable("id")UUID id){
        var idDto = new IdDto(id);
        log.info(idDto.toString());
        addressCustomerDeleteSendMessage.sendMessage(idDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
