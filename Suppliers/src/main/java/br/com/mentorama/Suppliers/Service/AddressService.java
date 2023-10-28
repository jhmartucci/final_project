package br.com.mentorama.Suppliers.Service;

import br.com.mentorama.Suppliers.Convert.Convert;
import br.com.mentorama.Suppliers.Dto.AddressDto;
import br.com.mentorama.Suppliers.Entity.Address;
import br.com.mentorama.Suppliers.Entity.Suppliers;
import br.com.mentorama.Suppliers.Repository.AddressRepository;
import br.com.mentorama.Suppliers.Repository.SuppliersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;
    @Autowired
    private final SuppliersRepository suppliersRepository;
    @Autowired
    private final Convert convert;

    public Address insertAddress(AddressDto addressDto){
        Optional<Suppliers> suppliers = suppliersRepository.findById(addressDto.getSuppliersId());

        if (suppliers.isPresent()){
            Address address = convert.convertAddressDtoToClass(addressDto);
            address.setSuppliers(suppliers.get());
            Address saveAddress = addressRepository.save(address);
            return saveAddress;
        }
        return null;
    }
    public Address updateAddress(Address address){
        Optional<Address> optionalAddress = addressRepository.findById(address.getId());

        return optionalAddress.isPresent()?
                addressRepository.save(address):
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
