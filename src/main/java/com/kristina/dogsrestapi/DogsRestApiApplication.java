package com.kristina.dogsrestapi;

import com.kristina.dogsrestapi.customer.CustomerService;
import com.kristina.dogsrestapi.customer.model.Customer;
import com.kristina.dogsrestapi.customer.model.CustomerConverter;
import com.kristina.dogsrestapi.customer.model.CustomerDTO;
import com.kristina.dogsrestapi.employee.EmployeeService;
import com.kristina.dogsrestapi.employee.model.EmployeeConverter;
import com.kristina.dogsrestapi.employee.model.EmployeeDTO;
import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import com.kristina.dogsrestapi.pet.PetService;
import com.kristina.dogsrestapi.pet.PetType;
import com.kristina.dogsrestapi.pet.model.Pet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DogsRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogsRestApiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDB(EmployeeService employeeService, CustomerService customerService, PetService petService) {
        return args -> {
            Customer customer = customerService.save(CustomerConverter.convertToEntity(new CustomerDTO("John", "Singer", "+4178787878", "Fake Customer", null)));
            petService.save(new Pet(1L, PetType.DOG, "Billy", customer, LocalDate.of(2020, 3, 10), "A cute Dog"));
            // customerService.save(CustomerConverter.convertToEntity(new CustomerDTO("John", "Singer", "+4178787878", "Another Fake Customer", Stream.of(new Pet(2L, PetType.CAT, "Whiskey", 2L, LocalDate.of(2020, 3, 10), "A cute Cat")).collect(Collectors.toSet()))));
            employeeService.save(EmployeeConverter.convertToEntity(new EmployeeDTO("Kylie", "Star", "+4178787878", Stream.of(EmployeeSkill.FEEDING, EmployeeSkill.SHAVING, EmployeeSkill.PETTING).collect(Collectors.toSet()), Stream.of(DayOfWeek.MONDAY, DayOfWeek.THURSDAY).collect(Collectors.toSet()), (long) 1000.00)));
            employeeService.save(EmployeeConverter.convertToEntity(new EmployeeDTO("Ona", "Johns", "+4178787878", Stream.of(EmployeeSkill.FEEDING).collect(Collectors.toSet()), Stream.of(DayOfWeek.MONDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY).collect(Collectors.toSet()), (long) 2000.00)));
        };
    }
}
