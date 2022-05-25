package com.kristina.dogsrestapi.pet;

import com.kristina.dogsrestapi.customer.CustomerService;
import com.kristina.dogsrestapi.customer.model.Customer;
import com.kristina.dogsrestapi.pet.model.Pet;
import com.kristina.dogsrestapi.pet.model.PetConverter;
import com.kristina.dogsrestapi.pet.model.PetDTO;
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
    private final CustomerService customerService;

    public PetController(PetService petService, CustomerService customerService) {
        this.petService = petService;
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable Long id) {
        Pet pet = petService.findPet(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PetDTO> savePet(@Valid @RequestBody PetDTO body) {
        Customer customer = customerService.getCustomer(body.getOwnerId());
        Pet pet = petService.save(PetConverter.toEntity(body, customer));
        return new ResponseEntity<>(PetConverter.toDTO(pet), HttpStatus.OK);
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<Set<Pet>> findAllByOwner(@PathVariable Long id) {
        Set<Pet> petDTOS = petService.getAllByOwnerId(id);
        return new ResponseEntity<>(petDTOS, HttpStatus.OK);
    }
    //@TODO find all pets by name and birth date interval
}
