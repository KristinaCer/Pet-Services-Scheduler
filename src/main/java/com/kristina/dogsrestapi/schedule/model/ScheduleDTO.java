package com.kristina.dogsrestapi.schedule.model;

import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {
    private long id;
    private Set<Long> employeeIds;
    private Set<Long> petIds;
    private LocalDate date;
    private Set<EmployeeSkill> activities;
}
