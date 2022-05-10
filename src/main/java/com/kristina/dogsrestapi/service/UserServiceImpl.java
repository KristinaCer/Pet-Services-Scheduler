package com.kristina.dogsrestapi.service;

import com.kristina.dogsrestapi.entity.Employee;
import com.kristina.dogsrestapi.entity.User;
import com.kristina.dogsrestapi.exception.UserNotFoundException;
import com.kristina.dogsrestapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Employee findEmployeeById(Long empId) {
        Employee emp = userRepository.findEmployeeById(empId).orElseThrow(UserNotFoundException::new);
        return emp;
    }

    @Override
    public Set<Employee> getEmployees() {
        return userRepository.findAllEmployees();
    }

    @Override
    public Set<User> getAllUsers() {
        return null;
    }
}
