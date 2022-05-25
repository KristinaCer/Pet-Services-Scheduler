package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import com.kristina.dogsrestapi.schedule.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("select s from  Schedule s  where s.pet.id = :petId")
    Schedule getByPetId(long petId);

    @Query("select s from  Schedule s  where s.employee.id = :employeeId")
    Schedule getByEmployeeId(long employeeId);
}
