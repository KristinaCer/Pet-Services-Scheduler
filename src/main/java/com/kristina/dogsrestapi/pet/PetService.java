package com.kristina.dogsrestapi.pet;

import com.kristina.dogsrestapi.pet.model.Pet;

public interface PetService {
    Pet save(Pet convertToEntity);
}
