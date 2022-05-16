package com.kristina.dogsrestapi.employee;

import com.kristina.dogsrestapi.employee.model.Employee;
import com.kristina.dogsrestapi.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Long create(Employee employee) {
        //userRepository.save(employee.getUser()); - same as @OneToOne (cascade = CascadeType.ALL) User user
        return employeeRepository.save(employee).getId();
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Long update(Employee employee) {
        return employeeRepository.save(employee).getId();
    }

    @Override
    public Employee getById(Long id) {
        //@TODO include Error messages
        return employeeRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Employee getByName(String name) {
        return null;
    }
}
