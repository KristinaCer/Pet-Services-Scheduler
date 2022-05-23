package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.employee.EmployeeService;
import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import com.kristina.dogsrestapi.pet.PetService;
import com.kristina.dogsrestapi.schedule.model.Schedule;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final EmployeeService employeeService;
    private final PetService petService;

    public ScheduleServiceImpl(EmployeeService employeeService, PetService petService) {
        this.employeeService = employeeService;
        this.petService = petService;
    }

    @Override
    public Schedule save(LocalDate date, Set<Long> employeeIds, Set<Long> petIds, Set<EmployeeSkill> activities) {
        //Checks if all the provided employee IDs exists and throws a User Not Found exception if they do not.
        employeeIds.stream().forEach(
                employeeService::findEmployee
        );
        //Checks if all the provided pet IDs exists and throws a Pet Not Found exception if they do not.
        petIds.stream().forEach(petId -> {
            petService.getPet(petId);
        });

        return null;
    }
}
