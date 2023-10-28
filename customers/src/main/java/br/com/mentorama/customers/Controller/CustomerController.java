package br.com.mentorama.customers.Controller;

import br.com.mentorama.customers.Convert.Convert;
import br.com.mentorama.customers.Dto.CustomerDto;
import br.com.mentorama.customers.Entity.Customer;
import br.com.mentorama.customers.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final Convert convert;

    @PostMapping("/create")
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto){
        try {
            Customer customer = customerService.insertCustomer(convert.convertCustomerDtoToClass(customerDto));
            return new ResponseEntity(customer, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable("id")UUID id, @RequestBody CustomerDto customerDto){


        Customer customer = convert.convertCustomerDtoToClass(customerDto);
        customer.setId(id);
        Customer updateCustomer = customerService.updateCustomer(customer);

        return Objects.nonNull(updateCustomer)?
                new ResponseEntity(updateCustomer,HttpStatus.OK):
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity findByIdCustomer(@PathVariable("id") UUID id){
        Optional<Customer> customer = customerService.findByIdCustomer(id);
        return customer.isPresent()?
                new ResponseEntity(customer,HttpStatus.OK):
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") UUID id){

        return customerService.deleteCustomer(id)?
                new ResponseEntity(HttpStatus.OK):
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
