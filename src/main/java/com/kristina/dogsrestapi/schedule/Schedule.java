package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.pet.Pet;
import com.kristina.dogsrestapi.user.Employee;
import com.kristina.dogsrestapi.user.EmployeeSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany
    private List<Employee> employeeIds;
    @ManyToMany
    private List<Pet> petIds;
    private LocalDate date;
    @ElementCollection
    private Set<EmployeeSkill> activities;
}
