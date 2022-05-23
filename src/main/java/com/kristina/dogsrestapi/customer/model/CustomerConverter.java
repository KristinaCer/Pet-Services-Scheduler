package com.kristina.dogsrestapi.customer.model;

import com.kristina.dogsrestapi.schedule.model.user.model.User;
import com.kristina.dogsrestapi.schedule.model.user.model.UserRole;

public final class CustomerConverter {

    public static CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(customer.getUser().getFirstName());
        customerDTO.setLastName(customer.getUser().getLastName());
        customerDTO.setPhoneNumber(customer.getUser().getPhoneNumber());
        customerDTO.setNotes(customer.getNotes());
        customerDTO.setPets(customer.getPets());
        return customerDTO;
    }

    public static Customer convertToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        User user = new User();
        user.setUserRole(UserRole.CUSTOMER);
        user.setFirstName(customerDTO.getFirstName());
        user.setLastName(customerDTO.getLastName());
        user.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setUser(user);
        customer.setNotes(customerDTO.getNotes());
        customer.setPets(customerDTO.getPets());
        return customer;
    }
}
