package com.kristina.dogsrestapi.customer.model;

import com.kristina.dogsrestapi.pet.model.Pet;
import com.kristina.dogsrestapi.schedule.model.user.model.User;
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
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private String notes;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Pet> pets;
}
