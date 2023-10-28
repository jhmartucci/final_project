package com.br.mentorama.BFF.Controller.Supplier;

import com.br.mentorama.BFF.Dto.IdDto;
import com.br.mentorama.BFF.Dto.Supplier.AddressSuppliersDto;
import com.br.mentorama.BFF.Dto.Supplier.AddressSuppliersUpdateDto;
import com.br.mentorama.BFF.Message.Supplier.AddressSuplliersSendMessage;
import com.br.mentorama.BFF.Message.Supplier.AddressSuppliersDeleteSendMessage;
import com.br.mentorama.BFF.Message.Supplier.AddressSuppliersUpdateSendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bff/suppliers/address")
@RequiredArgsConstructor
@Slf4j
public class AddressSuppliersController {

    @Autowired
    private final AddressSuplliersSendMessage addressSuplliersSendMessage;
    @Autowired
    private final AddressSuppliersUpdateSendMessage addressSuppliersUpdateSendMessage;
    @Autowired
    private final AddressSuppliersDeleteSendMessage addressSuppliersDeleteSendMessage;

    @PostMapping("/create")
    public ResponseEntity createAdressSuplliers(@RequestBody AddressSuppliersDto addressSuppliersDto){
        log.info(addressSuppliersDto.toString());
        addressSuplliersSendMessage.sendMessage(addressSuppliersDto);
        return new ResponseEntity<>(addressSuppliersDto,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAddressSuppliers(@PathVariable("id")UUID id,
                                                 @RequestBody AddressSuppliersUpdateDto addressSuppliersUpdateDto){
        addressSuppliersUpdateDto.setId(id);
        log.info(addressSuppliersUpdateDto.toString());
        addressSuppliersUpdateSendMessage.sendMessage(addressSuppliersUpdateDto);
        return new ResponseEntity<>(addressSuppliersUpdateDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddressSuppliers(@PathVariable("id")UUID id){
        var idDto = new IdDto(id);
        log.info(idDto.toString());
        addressSuppliersDeleteSendMessage.sendMessage(idDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
