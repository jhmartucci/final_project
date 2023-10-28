package br.com.mentorama.product.Controller;

import br.com.mentorama.product.Convert.Convert;
import br.com.mentorama.product.Dto.ProductDto;
import br.com.mentorama.product.Entity.Product;
import br.com.mentorama.product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;
    @Autowired
    private final Convert convert;

    @PostMapping("/create")
    public ResponseEntity insertProduct(@RequestBody ProductDto productDto){
        try {
            Product product = productService.insertProduct(convert.convertProductDtoToClass(productDto));
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable("id")UUID id, @RequestBody ProductDto productDto){
        Product product = convert.convertProductDtoToClass(productDto);
        product.setId(id);
        Product updateProduct = productService.updateProduct(product);

        return Objects.nonNull(updateProduct)?
                new ResponseEntity<>(product,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity findByIdProduct(@PathVariable("id")UUID id){
        Optional<Product> product = productService.findByIdProduct(id);

        return product.isPresent()?
                new ResponseEntity<>(product,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id){
        return productService.deleteProduct(id)?
                new ResponseEntity<>(HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

