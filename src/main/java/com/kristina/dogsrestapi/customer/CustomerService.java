package com.kristina.dogsrestapi.customer;

import com.kristina.dogsrestapi.customer.model.Customer;
import com.kristina.dogsrestapi.customer.model.CustomerDTO;
import org.springframework.stereotype.Service;

public interface CustomerService {
    Customer save(Customer convertToCustomer);
}
