package com.kristina.dogsrestapi.pet;

import com.kristina.dogsrestapi.customer.CustomerRepository;
import com.kristina.dogsrestapi.customer.model.Customer;
import com.kristina.dogsrestapi.exception.PetNotFoundException;
import com.kristina.dogsrestapi.exception.UserNotFoundException;
import com.kristina.dogsrestapi.pet.model.Pet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    public PetServiceImpl(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Pet save(Pet pet) {
        long ownerId = pet.getOwner().getId();
        Customer customer = customerRepository.findById(ownerId).orElseThrow(() -> new UserNotFoundException(String.format("Pet owner with ID %d was not found.", ownerId)));
        pet.setOwner(customer);
        return petRepository.save(pet);
    }

    @Override
    public Set<Pet> getAllByOwnerId(Long id) {
        return null;
    }

    @Override
    public Pet findPet(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new PetNotFoundException(String.format("Pet with ID %d was not found.", id)));
    }
}
