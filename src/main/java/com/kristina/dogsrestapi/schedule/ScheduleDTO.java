package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

/**
 * Represents the form that schedule request and response data takes. Does not map
 * to the database directly.
 */
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
