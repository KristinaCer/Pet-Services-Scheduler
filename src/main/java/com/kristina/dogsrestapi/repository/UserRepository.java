package com.kristina.dogsrestapi.repository;

import com.kristina.dogsrestapi.entity.Employee;
import com.kristina.dogsrestapi.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.type='employee'")
    Optional<Employee> findEmployeeById(Long id);

    //@TODO How to correctly handle a situation when there are no employees/users in the DB?

    @Query("select u from User u where u.type='employee'")
    public Set<Employee> findAllEmployees();

   // public Set<User> findAllUsers();

}
