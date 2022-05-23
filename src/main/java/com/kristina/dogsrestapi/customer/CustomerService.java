package com.kristina.dogsrestapi.customer;

import com.kristina.dogsrestapi.customer.model.Customer;

public interface CustomerService {
    Customer save(Customer convertToCustomer);
}
