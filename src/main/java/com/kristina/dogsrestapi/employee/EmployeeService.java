package com.kristina.dogsrestapi.employee;

import com.kristina.dogsrestapi.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Long create(Employee employee);

    List<Employee> getAll();

    Long update(Employee employee);

    Employee getById(Long id);

    Employee getByName(String name);
}
