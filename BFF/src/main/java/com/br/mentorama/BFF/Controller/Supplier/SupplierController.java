package com.br.mentorama.BFF.Controller.Supplier;

import com.br.mentorama.BFF.Dto.IdDto;
import com.br.mentorama.BFF.Dto.Supplier.SuppliersDto;
import com.br.mentorama.BFF.Dto.Supplier.SuppliersUpdateDto;
import com.br.mentorama.BFF.Message.Supplier.SupplierDeleteSendMessage;
import com.br.mentorama.BFF.Message.Supplier.SupplierSendMessage;
import com.br.mentorama.BFF.Message.Supplier.SupplierUpdateSendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bff/suppliers")
@RequiredArgsConstructor
@Slf4j
public class SupplierController {

    @Autowired
    private final SupplierSendMessage supplierSendMessage;
    @Autowired
    private final SupplierUpdateSendMessage supplierUpdateSendMessage;
    @Autowired
    private final SupplierDeleteSendMessage supplierDeleteSendMessage;

    @PostMapping("/create")
    public ResponseEntity createSupplier(@RequestBody SuppliersDto suppliersDto){
        log.info(suppliersDto.toString());
        supplierSendMessage.sendMessage(suppliersDto);
        return new ResponseEntity<>(suppliersDto,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateSupplier(@PathVariable("id")UUID id, @RequestBody SuppliersUpdateDto suppliersUpdateDto){
        suppliersUpdateDto.setId(id);
        log.info(suppliersUpdateDto.toString());
        supplierUpdateSendMessage.sendMessage(suppliersUpdateDto);
        return new ResponseEntity(suppliersUpdateDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSupplier(@PathVariable("id")UUID id){
        var idDto = new IdDto(id);
        log.info(idDto.toString());
        supplierDeleteSendMessage.sendMessage(idDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
