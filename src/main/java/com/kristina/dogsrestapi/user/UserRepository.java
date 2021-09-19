package com.kristina.dogsrestapi.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    Employee findEmployeeById(Long id);

    @Query("select u from User u where u.type='customer'")
    public List<User> findAllCustomers();

    @Query("select e from Employee e Left Join User u on e.id = u.id")
    public List<User> findAllEmployees();

    @Query("select u from User u where :id member of u.petIds")
    public User getOwnerByPet(Long id);
}
