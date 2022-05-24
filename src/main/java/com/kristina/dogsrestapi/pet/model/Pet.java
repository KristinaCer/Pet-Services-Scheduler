package com.kristina.dogsrestapi.pet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kristina.dogsrestapi.customer.model.Customer;
import com.kristina.dogsrestapi.pet.PetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @Enumerated(EnumType.STRING)
    private PetType type;
    @Nationalized
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer owner;
    private LocalDate birthDate;
    private String notes;
}
