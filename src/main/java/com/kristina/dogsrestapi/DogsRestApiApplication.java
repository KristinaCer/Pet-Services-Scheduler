package com.kristina.dogsrestapi;

import com.kristina.dogsrestapi.employee.EmployeeService;
import com.kristina.dogsrestapi.employee.model.EmployeeConverter;
import com.kristina.dogsrestapi.employee.model.EmployeeDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            employeeService.create(EmployeeConverter.convertToEntity(new EmployeeDTO("Kylie Star", "+4178787878", null, null)));
            employeeService.create(EmployeeConverter.convertToEntity(new EmployeeDTO("Ona Johns", "+4178787878", null, null)));
        };
    }
}
