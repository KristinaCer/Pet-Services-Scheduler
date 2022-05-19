package com.kristina.dogsrestapi.employee;

import com.kristina.dogsrestapi.employee.model.Employee;
import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select e from Employee e Join User u on e.id = u.id where u.firstName =:firstName and u.lastName = :lastName")
    Optional<Employee> findFirstByNameAndLastName(String firstName, String lastName);

    @Query
    Optional<Set<Employee>> findBySkills(Set<EmployeeSkill> skills);
}
