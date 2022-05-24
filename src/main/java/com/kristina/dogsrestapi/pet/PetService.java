package com.kristina.dogsrestapi.pet;

import com.kristina.dogsrestapi.pet.model.Pet;

import java.util.Set;

public interface PetService {
    Pet save(Pet convertToEntity);

    Set<Pet> getAllByOwnerId(Long id);

    Pet findPet(Long id);
}
