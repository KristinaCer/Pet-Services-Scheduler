package com.kristina.dogsrestapi.customer;

import com.kristina.dogsrestapi.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Represents the form that customer request and response data takes. Does not map
 * to the database directly.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String name;
    private String phoneNumber;
    private String notes;
    private Set<Pet> pets;
}
