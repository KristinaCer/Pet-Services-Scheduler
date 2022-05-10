package com.kristina.dogsrestapi.service;

import com.kristina.dogsrestapi.entity.Employee;
import com.kristina.dogsrestapi.entity.User;

import java.util.Set;

public interface UserService {
    Employee findEmployeeById(Long empId);
    Set<Employee> getEmployees();
    Set<User> getAllUsers();
}
