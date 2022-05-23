package com.kristina.dogsrestapi.customer;

import com.kristina.dogsrestapi.customer.model.Customer;
import com.kristina.dogsrestapi.customer.model.CustomerConverter;
import com.kristina.dogsrestapi.customer.model.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.save(CustomerConverter.convertToEntity(customerDTO));
        return new ResponseEntity<>(CustomerConverter.convertToDTO(customer), HttpStatus.OK);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId) {
        throw new UnsupportedOperationException();
    }
}
