package com.kristina.dogsrestapi.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User {

    private String type="employee";

    @ElementCollection
    //With EnumType.ORDINAL a numeric value will be assigned respectively to each Enum value in the database
    //With EnumType.STRING a string will be assigned to each Enum value in the database as well
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkill> skills;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> daysAvailable;
}
