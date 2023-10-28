package br.com.mentorama.customers.Convert;

import br.com.mentorama.customers.Dto.AddressDto;
import br.com.mentorama.customers.Dto.AddressUpdateDto;
import br.com.mentorama.customers.Dto.CustomerDto;
import br.com.mentorama.customers.Dto.CustomerUpdateDto;
import br.com.mentorama.customers.Entity.Address;
import br.com.mentorama.customers.Entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Convert {

    public Customer convertCustomerDtoToClass(CustomerDto customerDto){
        return new ModelMapper().map(customerDto, Customer.class);
    }
    public Customer convertCustomerUpdateDtoToClass(CustomerUpdateDto customerUpdateDto){
        return new ModelMapper().map(customerUpdateDto, Customer.class);
    }
    public Address convertAddressDtoToClass(AddressDto addressDto){
        return new ModelMapper().map(addressDto, Address.class);
    }
    public Address convertAddresUpdateDtoToClass(AddressUpdateDto addressUpdateDto){
        return new ModelMapper().map(addressUpdateDto, Address.class);
    }

}
