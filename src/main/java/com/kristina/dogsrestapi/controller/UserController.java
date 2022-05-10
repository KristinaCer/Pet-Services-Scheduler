package com.kristina.dogsrestapi.controller;

import com.kristina.dogsrestapi.entity.Employee;
import com.kristina.dogsrestapi.entity.User;
import com.kristina.dogsrestapi.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Handles web requests related to Users.
 * <p>
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Set<User>> getAllUsers() {
        Set<User> users = service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee emp = service.findEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("employees")
    public ResponseEntity<Set<Employee>> getEmployees() {
        Set<Employee> employees = service.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
