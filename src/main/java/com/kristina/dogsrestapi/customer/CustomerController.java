package com.kristina.dogsrestapi.customer;

import com.kristina.dogsrestapi.customer.model.Customer;
import com.kristina.dogsrestapi.customer.model.CustomerConverter;
import com.kristina.dogsrestapi.customer.model.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user/customer")
public class CustomerController{

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.save(CustomerConverter.convertToEntity(customerDTO));
        return new ResponseEntity<>(CustomerConverter.convertToDTO(customer), HttpStatus.OK);
    }
}
