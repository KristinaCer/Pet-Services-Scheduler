package com.kristina.dogsrestapi;

import com.kristina.dogsrestapi.user.UserRepository;
import com.kristina.dogsrestapi.user.model.Customer;
import com.kristina.dogsrestapi.user.model.CustomerDTO;
import com.kristina.dogsrestapi.user.model.Employee;
import com.kristina.dogsrestapi.user.model.EmployeeDTO;
import org.springframework.beans.BeanUtils;
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
    CommandLineRunner initDB(UserRepository userRepository) {
        return args -> {
            userRepository.save(convertCustomerDTOToCustomer(new CustomerDTO("John Singer", "+4178787878", "Fake Customer", null)));
            userRepository.save(convertCustomerDTOToCustomer(new CustomerDTO("Anna Homes", "+4178787878", "Fake Customer1", null)));
            userRepository.save(convertCustomerDTOToCustomer(new CustomerDTO("Lynn Stevenson", "+4178787878", "Fake Customer1", null)));
            userRepository.save(convertCustomerDTOToCustomer(new CustomerDTO("Andres Holmes", "+4178787878", "Fake Customer1", null)));
            userRepository.save(convertEmployeeDTOToEmployee(new EmployeeDTO("Kylie Star", null, null)));
            userRepository.save(convertEmployeeDTOToEmployee(new EmployeeDTO("Ona Johns", null, null)));
        };
    }
    private static Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }
    private static Employee convertEmployeeDTOToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        return employee;
    }
}
