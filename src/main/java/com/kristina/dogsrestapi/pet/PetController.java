package com.kristina.dogsrestapi.pet;

import com.kristina.dogsrestapi.pet.model.Pet;
import com.kristina.dogsrestapi.pet.model.PetConverter;
import com.kristina.dogsrestapi.pet.model.PetDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<PetDTO> savePet(@Valid @RequestBody PetDTO petDTO) {
        Pet pet = petService.save(PetConverter.convertToEntity(petDTO));
        return new ResponseEntity<>(PetConverter.convertToDto(pet), HttpStatus.OK);
    }
}
