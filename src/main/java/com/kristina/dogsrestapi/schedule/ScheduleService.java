package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import com.kristina.dogsrestapi.schedule.model.Schedule;

import java.time.LocalDate;
import java.util.Set;

public interface ScheduleService {
    public Schedule save(LocalDate date, Set<Long> employeeIds, Set<Long> petIds, Set<EmployeeSkill> activities);
}
