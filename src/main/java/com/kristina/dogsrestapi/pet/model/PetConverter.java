package com.kristina.dogsrestapi.pet.model;

public final class PetConverter {

    public static Pet convertToEntity(PetDTO petDTO){
        Pet pet = new Pet();
        pet.setName(petDTO.getName());
        pet.setBirthDate(petDTO.getBirthDate());
        pet.setNotes(petDTO.getNotes());
        pet.setType(petDTO.getType());
        pet.setOwnerId(petDTO.getOwnerId());
        return pet;
    }

    public static PetDTO convertToDto(Pet pet){
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setType(pet.getType());
        petDTO.setName(pet.getName());
        petDTO.setBirthDate(pet.getBirthDate());
        petDTO.setOwnerId(pet.getOwnerId());
        petDTO.setNotes(pet.getNotes());
        return petDTO;
    }
}
