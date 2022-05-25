package com.kristina.dogsrestapi.customer;

import com.kristina.dogsrestapi.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer convertToCustomer);

    List<Customer> getAll();

    Customer getOwnerByPet(long petId);

    Customer getCustomer(Long id);
}
