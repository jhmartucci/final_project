package br.com.mentorama.customers.Service;

import br.com.mentorama.customers.Convert.Convert;
import br.com.mentorama.customers.Dto.AddressDto;
import br.com.mentorama.customers.Entity.Address;
import br.com.mentorama.customers.Entity.Customer;
import br.com.mentorama.customers.Repository.AddressRepository;
import br.com.mentorama.customers.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final Convert convert;

    public Address insertAddress(AddressDto addressDto){
        Optional<Customer> customer = customerRepository.findById(addressDto.getCustomerId());

        if (customer.isPresent()){
            Address address = convert.convertAddressDtoToClass(addressDto);
            address.setCustomer(customer.get());
            Address saveAddress = addressRepository.save(address);
            return saveAddress;
        }
        return null;
    }
    public Address updateAddress(Address adress){
        Optional<Address> optionalAddress =addressRepository.findById(adress.getId());

        return optionalAddress.isPresent()?
                addressRepository.save(adress):
                null;
    }
    public boolean deleteAddress(UUID id){
        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent()){
            addressRepository.delete(address.get());
            return true;
        }else{
            return false;
        }
    }
    public Optional<Address> findByIdAddress(UUID id){
        return addressRepository.findById(id);
    }
}
