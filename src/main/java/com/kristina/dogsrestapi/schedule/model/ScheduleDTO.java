package com.kristina.dogsrestapi.schedule.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {
    private Long employeeId;
    private Long petId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private EmployeeSkill activity;
}
