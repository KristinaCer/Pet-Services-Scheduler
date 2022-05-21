package com.kristina.dogsrestapi.customer;

import com.kristina.dogsrestapi.pet.Pet;
import com.kristina.dogsrestapi.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    private String notes;
    @OneToMany
    private Set<Pet> pets;
}
