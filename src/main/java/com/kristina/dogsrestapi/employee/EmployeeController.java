package com.kristina.dogsrestapi.employee;

import com.kristina.dogsrestapi.employee.model.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.kristina.dogsrestapi.employee.model.EmployeeConverter.convertToDTO;

@RestController
@RequestMapping("user/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public HttpEntity<List<EmployeeDTO>> getAll() {
        List<EmployeeDTO> employeeDTOS = employeeService.getAll().stream().map(e -> convertToDTO(e)).collect(Collectors.toList());
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findEmployee(id);
        return new ResponseEntity<>(convertToDTO(employee), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<EmployeeDTO> findEmployeeByName(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.findByFirstNameAndLastName(firstName, lastName);
        return new ResponseEntity<>(convertToDTO(employee), HttpStatus.OK);
    }

    @GetMapping("/skills")
    public ResponseEntity<Set<EmployeeDTO>> findEmployeesBySkills(@RequestBody Set<EmployeeSkill> skills) {
        Set<Employee> employees = employeeService.findEmployeesBySkills(skills);
        Set<EmployeeDTO> employeeDTOS = employees.stream().map(employee -> convertToDTO(employee)).collect(Collectors.toSet());
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }

    @GetMapping("/availability")
    public ResponseEntity<Set<EmployeeDTO>> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeRequestDT0) {
        Set<EmployeeDTO> employeeDTOS = employeeService.findBySkillsAndDate(employeeRequestDT0.getSkills(), employeeRequestDT0.getDate()).stream().map(employee -> convertToDTO(employee)).collect(Collectors.toSet());
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@Valid @RequestBody EmployeeDTO body) {
        Employee emp = employeeService.save(EmployeeConverter.convertToEntity(body));
        return new ResponseEntity<>(EmployeeConverter.convertToDTO(emp), HttpStatus.OK);
    }

    //@TODO Can you prevent requests from creating invalid schedules?
    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeSchedule(@Valid @RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        Employee e = employeeService.findEmployee(employeeId);
        e.setDaysAvailable(daysAvailable);
        return new ResponseEntity<>(EmployeeConverter.convertToDTO(employeeService.save(e)), HttpStatus.OK);
    }

    //@Todo Find employee count and average salary by a particular skill


}
