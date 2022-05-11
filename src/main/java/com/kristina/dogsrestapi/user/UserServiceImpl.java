package com.kristina.dogsrestapi.user;

import com.kristina.dogsrestapi.exception.UserNotFoundException;
import com.kristina.dogsrestapi.user.model.Employee;
import com.kristina.dogsrestapi.user.model.User;
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
