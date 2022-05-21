package com.kristina.dogsrestapi.employee;

import com.kristina.dogsrestapi.employee.model.Employee;
import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select e from Employee e Join User u on e.id = u.id where u.firstName =:firstName or u.lastName = :lastName")
    Optional<Employee> findFirstByNameAndLastName(String firstName, String lastName);

//    @Query(value = "SELECT u FROM Employee u LEFT JOIN u.skills sk GROUP BY u"
//            + " HAVING SUM(CASE WHEN sk IN (:skills) THEN 1 ELSE -1 END) = :skillListSize")
    @Query(value = "SELECT u FROM Employee u LEFT JOIN u.skills sk WHERE sk IN :skills and sk.size = :skillListSize")
    Optional<Set<Employee>> findBySkills(Set<EmployeeSkill> skills, Integer skillListSize);

    Optional<Set<Employee>>findBySkillsInAndDaysAvailableContains(Set<EmployeeSkill> employeeSkills, DayOfWeek dayOfWeek);
}
