package br.com.mentorama.customers.Service;

import br.com.mentorama.customers.Entity.Customer;
import br.com.mentorama.customers.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;


    public Customer insertCustomer(Customer customer){
         return customerRepository.save(customer);

    }
    public Customer updateCustomer(Customer customer){
        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());

        return customerOptional.isPresent()?
                customerRepository.save(customer):
                null;
    }

    public boolean deleteCustomer(UUID id){
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()){
            customerRepository.delete(customer.get());
            return true;
        }else {
            return false;
        }
    }
    public Optional<Customer> findByIdCustomer(UUID id){
        return customerRepository.findById(id);
    }
}
