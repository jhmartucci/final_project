package br.com.mentorama.Suppliers.Service;

import br.com.mentorama.Suppliers.Entity.Suppliers;
import br.com.mentorama.Suppliers.Repository.SuppliersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class SuppliersService {

    @Autowired
    private final SuppliersRepository suppliersRepository;

    public Suppliers insertSuppliers(Suppliers suppliers){
        return suppliersRepository.save(suppliers);
    }
    public Suppliers updateSuppliers(Suppliers suppliers){
        Optional<Suppliers> suppliersOptional = suppliersRepository.findById(suppliers.getId());

        return suppliersOptional.isPresent()?
                suppliersRepository.save(suppliers):
                null;
    }
    public boolean deleteSuppliers(UUID id){
        Optional<Suppliers> suppliers = suppliersRepository.findById(id);

        if (suppliers.isPresent()){
            suppliersRepository.delete(suppliers.get());
            return true;
        }else{
            return false;
        }
    }
    public Optional<Suppliers> findByIdSuppliers(UUID id){
        return suppliersRepository.findById(id);
    }
}
