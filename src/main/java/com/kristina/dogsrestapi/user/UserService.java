package com.kristina.dogsrestapi.user;

import com.kristina.dogsrestapi.user.model.Employee;
import com.kristina.dogsrestapi.user.model.User;

import java.util.Set;

public interface UserService {
    Employee findEmployeeById(Long empId);
    Set<Employee> getEmployees();
    Set<User> getAllUsers();
}
