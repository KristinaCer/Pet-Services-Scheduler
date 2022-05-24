package com.kristina.dogsrestapi.pet.model;

import com.kristina.dogsrestapi.pet.PetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    private PetType type;
    private String name;
    private Long ownerId;
    private LocalDate birthDate;
    private String notes;
}