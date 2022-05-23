package com.kristina.dogsrestapi.pet;

import com.kristina.dogsrestapi.customer.CustomerRepository;
import com.kristina.dogsrestapi.exception.UserNotFoundException;
import com.kristina.dogsrestapi.pet.model.Pet;
import org.springframework.stereotype.Service;

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
        long ownerId = pet.getOwnerId();
        customerRepository.findById(ownerId).orElseThrow(() -> new UserNotFoundException(String.format("Pet owner with ID %d was not found.", ownerId)));
        return petRepository.save(pet);
    }
}
