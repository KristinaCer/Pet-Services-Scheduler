package com.kristina.dogsrestapi;

import com.kristina.dogsrestapi.employee.EmployeeService;
import com.kristina.dogsrestapi.employee.model.EmployeeConverter;
import com.kristina.dogsrestapi.employee.model.EmployeeDTO;
import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DogsRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogsRestApiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDB(EmployeeService employeeService) {
        return args -> {
//            userRepository.save(convertCustomerDTOToCustomer(new CustomerDTO("John Singer", "+4178787878", "Fake Customer", null)));
//            userRepository.save(convertCustomerDTOToCustomer(new CustomerDTO("Anna Homes", "+4178787878", "Fake Customer1", null)));
//            userRepository.save(convertCustomerDTOToCustomer(new CustomerDTO("Lynn Stevenson", "+4178787878", "Fake Customer1", null)));
//            userRepository.save(convertCustomerDTOToCustomer(new CustomerDTO("Andres Holmes", "+4178787878", "Fake Customer1", null)));
            employeeService.save(EmployeeConverter.convertToEntity(new EmployeeDTO("Kylie", "Star","+4178787878", Stream.of( EmployeeSkill.FEEDING, EmployeeSkill.SHAVING, EmployeeSkill.PETTING).collect(Collectors.toSet()), Stream.of(DayOfWeek.MONDAY, DayOfWeek.THURSDAY).collect(Collectors.toSet()))));
            employeeService.save(EmployeeConverter.convertToEntity(new EmployeeDTO("Ona", "Johns","+4178787878", Stream.of( EmployeeSkill.FEEDING).collect(Collectors.toSet()), Stream.of(DayOfWeek.MONDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY).collect(Collectors.toSet()))));
        };
    }
}
