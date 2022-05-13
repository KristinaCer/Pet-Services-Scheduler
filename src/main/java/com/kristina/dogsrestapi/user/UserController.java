package com.kristina.dogsrestapi.user;

import com.kristina.dogsrestapi.user.model.Employee;
import com.kristina.dogsrestapi.user.model.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private final ModelMapper mapper;

    public UserController(UserServiceImpl service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return null;
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return null;
    }

}
