package com.kristina.dogsrestapi.schedule.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kristina.dogsrestapi.employee.model.Employee;
import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import com.kristina.dogsrestapi.pet.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    private LocalDate date;
    @OneToOne
    @JsonIgnore
    private Employee employee;
    @JsonIgnore
    @OneToOne
    private Pet pet;
    @Enumerated(EnumType.STRING)
    private EmployeeSkill activity;
}
