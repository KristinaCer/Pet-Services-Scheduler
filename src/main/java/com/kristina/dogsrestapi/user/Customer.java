package com.kristina.dogsrestapi.user;

import com.kristina.dogsrestapi.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {

    private String type="customer";
    private String phoneNumber;
    private String notes;

    @ElementCollection
    private List<Long> petIds;
}
