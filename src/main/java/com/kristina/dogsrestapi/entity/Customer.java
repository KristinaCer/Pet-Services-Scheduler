package com.kristina.dogsrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {
    private String type="customer";
    private String phoneNumber;
    private String notes;
}
