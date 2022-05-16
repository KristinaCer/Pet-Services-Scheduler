package com.kristina.dogsrestapi.employee;

import com.kristina.dogsrestapi.employee.model.Employee;
import com.kristina.dogsrestapi.employee.model.EmployeeConverter;
import com.kristina.dogsrestapi.employee.model.EmployeeDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.kristina.dogsrestapi.employee.model.EmployeeConverter.convertToDTO;
import static com.kristina.dogsrestapi.employee.model.EmployeeConverter.convertToEntity;

@RestController
@RequestMapping("api/employees")
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
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        return new ResponseEntity<>(convertToDTO(employee), HttpStatus.OK);
    }

//    @GetMapping("/{name}")
//    public ResponseEntity<EmployeeDTO> getByName(@PathVariable String name) {
//        Employee employee = employeeService.getByName(name);
//        return new ResponseEntity<>(convertToDTO(employee), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody EmployeeDTO body) {
        return new ResponseEntity<>(employeeService.create(EmployeeConverter.convertToEntity(body)), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@Valid @RequestBody EmployeeDTO body) {
        Employee employee = convertToEntity(body);
        return new ResponseEntity<>(employeeService.update(employee), HttpStatus.OK);
    }

    public void changeEmployeeAvailability(){

    }

    public List<Employee> findEmployeesByServiceAndTime(){
        return null;
    }
}
