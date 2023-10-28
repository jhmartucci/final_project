package br.com.mentorama.Suppliers.Controller;

import br.com.mentorama.Suppliers.Convert.Convert;
import br.com.mentorama.Suppliers.Dto.SuppliersDto;
import br.com.mentorama.Suppliers.Entity.Suppliers;
import br.com.mentorama.Suppliers.Service.SuppliersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SuppliersController {

    @Autowired
    private final SuppliersService suppliersService;
    @Autowired
    private final Convert convert;

    @PostMapping("/create")
    public ResponseEntity insertSuppliers(@RequestBody SuppliersDto suppliersDto){
        try {
            Suppliers suppliers = suppliersService.insertSuppliers(convert.convertSuppliersDtoToClass(suppliersDto));
            return new ResponseEntity<>(suppliers, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateSuplliers(@PathVariable("id")UUID id, @RequestBody SuppliersDto suppliersDto){
        Suppliers suppliers = convert.convertSuppliersDtoToClass(suppliersDto);
        suppliers.setId(id);
        Suppliers updateSuppliers = suppliersService.updateSuppliers(suppliers);

        return Objects.nonNull(updateSuppliers)?
                new ResponseEntity<>(suppliers,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity findByIdSuppliers(@PathVariable("id") UUID id){
        Optional<Suppliers> suppliers = suppliersService.findByIdSuppliers(id);
        return suppliers.isPresent()?
                new ResponseEntity<>(suppliers,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSuppliers(@PathVariable("id") UUID id){
        return suppliersService.deleteSuppliers(id)?
                new ResponseEntity<>(HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
