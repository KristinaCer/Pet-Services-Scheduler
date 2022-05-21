package com.kristina.dogsrestapi.employee;

import com.kristina.dogsrestapi.employee.model.Employee;
import com.kristina.dogsrestapi.employee.model.EmployeeSkill;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAll();

    Employee findEmployee(Long id);

    Employee findByFirstNameAndLastName(String name, String lastName);

    Set<Employee> findEmployeesBySkills(Set<EmployeeSkill> skills);

    Set<Employee> findBySkillsAndDate(Set<EmployeeSkill> skills, LocalDate date);
}
