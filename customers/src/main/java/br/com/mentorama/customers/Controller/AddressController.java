package br.com.mentorama.customers.Controller;

import br.com.mentorama.customers.Convert.Convert;
import br.com.mentorama.customers.Dto.AddressDto;
import br.com.mentorama.customers.Entity.Address;
import br.com.mentorama.customers.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    @Autowired
    private final AddressService addressService;

    @Autowired
    private final Convert convert;

    @PostMapping("/create")
    public ResponseEntity insertAddress(@RequestBody AddressDto addressDto){
        try {
            addressService.insertAddress(addressDto);
            return Objects.nonNull(addressDto)?
                    new ResponseEntity(addressDto,HttpStatus.CREATED):
                    new ResponseEntity(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@PathVariable("id")UUID id, @RequestBody AddressDto addressDto){
        Address address = convert.convertAddressDtoToClass(addressDto);
        address.setId(id);
        Address upAddress = addressService.updateAddress(address);

        return Objects.nonNull(upAddress)?
                new ResponseEntity(address, HttpStatus.OK):
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable("id") UUID id){
        return addressService.deleteAddress(id)?
                new ResponseEntity(HttpStatus.OK):
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findByIdAddress(@PathVariable("id")UUID id){

        Optional<Address> address = addressService.findByIdAddress(id);

        return address.isPresent()?
                new ResponseEntity(address,HttpStatus.OK):
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
