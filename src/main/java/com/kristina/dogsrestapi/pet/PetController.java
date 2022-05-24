package com.kristina.dogsrestapi.pet;

import com.kristina.dogsrestapi.pet.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

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

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable Long id) {
        Pet pet = petService.findPet(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pet> savePet(@Valid @RequestBody Pet body) {
        //Converteri issitraukti Customer is db ir pasetinti.
        // Pet pet = petService.save(pet);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<Set<Pet>> findAllByOwner(@PathVariable Long id) {
        Set<Pet> petDTOS = petService.getAllByOwnerId(id);
        return new ResponseEntity<>(petDTOS, HttpStatus.OK);
    }
    //@TODO find all pets by name and birth date interval
}
