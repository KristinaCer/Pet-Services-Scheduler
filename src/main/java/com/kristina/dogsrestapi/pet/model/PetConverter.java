package com.kristina.dogsrestapi.pet.model;

import com.kristina.dogsrestapi.customer.CustomerService;
import com.kristina.dogsrestapi.customer.CustomerServiceImpl;
import com.kristina.dogsrestapi.customer.model.Customer;

public final class PetConverter {

    public static PetDTO toDTO(Pet pet) {
        PetDTO petDTO = new PetDTO();
        petDTO.setType(pet.getType());
        petDTO.setName(pet.getName());
        petDTO.setBirthDate(pet.getBirthDate());
        petDTO.setNotes(pet.getNotes());
        petDTO.setOwnerId(pet.getOwner().getId());
        return petDTO;
    }

    public static Pet toEntity(PetDTO body, Customer owner){
        Pet pet = new Pet();
        pet.setType(body.getType());
        pet.setBirthDate(body.getBirthDate());
        pet.setNotes(body.getNotes());
        pet.setOwner(owner);
        pet.setName(body.getName());
        return pet;
    }

}
