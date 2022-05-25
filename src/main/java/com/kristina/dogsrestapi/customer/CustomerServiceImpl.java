package com.kristina.dogsrestapi.customer;

import com.kristina.dogsrestapi.customer.model.Customer;
import com.kristina.dogsrestapi.pet.PetService;
import com.kristina.dogsrestapi.pet.model.Pet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final PetService petService;

    public CustomerServiceImpl(CustomerRepository customerRepository, PetService petService) {
        this.customerRepository = customerRepository;
        this.petService = petService;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOwnerByPet(long petId) {
//        Pet pet = petService.findPet(petId);
        return null;
    }
}
