package com.br.mentorama.BFF.Controller.Product;

import com.br.mentorama.BFF.Dto.IdDto;
import com.br.mentorama.BFF.Dto.Product.ProductDto;
import com.br.mentorama.BFF.Dto.Product.ProductUpdateDto;
import com.br.mentorama.BFF.Message.Product.ProductDeleteSendMessage;
import com.br.mentorama.BFF.Message.Product.ProductSendMessage;
import com.br.mentorama.BFF.Message.Product.ProductUpdateSendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bff/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    @Autowired
    private final ProductSendMessage productSendMessage;
    @Autowired
    private final ProductUpdateSendMessage productUpdateSendMessage;
    @Autowired
    private final ProductDeleteSendMessage productDeleteSendMessage;

    @PostMapping("/create")
    public ResponseEntity createProduct(@RequestBody ProductDto productDto){
        log.info(productDto.toString());
        productSendMessage.sendMessage(productDto);
        return new ResponseEntity<>(productDto,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable("id")UUID id, @RequestBody ProductUpdateDto productUpdateDto){
        productUpdateDto.setId(id);
        log.info(productUpdateDto.toString());
        productUpdateSendMessage.sendMessage(productUpdateDto);
        return new ResponseEntity<>(productUpdateDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id")UUID id){
        var idDto = new IdDto(id);
        log.info(idDto.toString());
        productDeleteSendMessage.sendMessage(idDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
