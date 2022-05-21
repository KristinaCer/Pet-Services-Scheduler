package com.kristina.dogsrestapi.employee;

import com.kristina.dogsrestapi.employee.model.Employee;
import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import com.kristina.dogsrestapi.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        //userRepository.save(employee.getUser()); - same as @OneToOne (cascade = CascadeType.ALL) User user or @Transactional
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " not found."));
    }

    @Override
    public Employee findByFirstNameAndLastName(String firstName, String lastName) {
        return employeeRepository.findFirstByNameAndLastName(firstName, lastName).orElseThrow(() -> new UserNotFoundException("User Name: " + firstName + " " + lastName));
    }


    @Override
    public Set<Employee> findEmployeesBySkills(Set<EmployeeSkill> skills) throws UserNotFoundException {
        return employeeRepository.findBySkills(skills, skills.size()).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Set<Employee> findBySkillsAndDate(Set<EmployeeSkill> skills, LocalDate date) throws UserNotFoundException {
        return employeeRepository.findBySkillsInAndDaysAvailableContains(skills, date.getDayOfWeek())
                .orElseThrow(UserNotFoundException::new);
    }
}
