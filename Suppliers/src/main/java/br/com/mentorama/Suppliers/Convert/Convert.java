package br.com.mentorama.Suppliers.Convert;

import br.com.mentorama.Suppliers.Dto.AddressDto;
import br.com.mentorama.Suppliers.Dto.AddressSuppliersUpdateDto;
import br.com.mentorama.Suppliers.Dto.SuppliersDto;
import br.com.mentorama.Suppliers.Dto.SuppliersUpdateDto;
import br.com.mentorama.Suppliers.Entity.Address;
import br.com.mentorama.Suppliers.Entity.Suppliers;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Convert {

    public Suppliers convertSuppliersDtoToClass(SuppliersDto suppliersDto){
        return new ModelMapper().map(suppliersDto, Suppliers.class);
    }
    public Suppliers convertSuppliersUpdateDtoToClass(SuppliersUpdateDto suppliersUpdateDto){
        return new ModelMapper().map(suppliersUpdateDto, Suppliers.class);
    }
    public Address convertAddressDtoToClass(AddressDto addressDto){
        return new ModelMapper().map(addressDto, Address.class);
    }
    public Address convertAddressUpdateDtoToClass(AddressSuppliersUpdateDto addressSuppliersUpdateDto){
        return new ModelMapper().map(addressSuppliersUpdateDto, Address.class);
    }
}
