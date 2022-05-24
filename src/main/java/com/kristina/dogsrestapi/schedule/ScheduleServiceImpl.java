package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.employee.EmployeeService;
import com.kristina.dogsrestapi.employee.model.Employee;
import com.kristina.dogsrestapi.pet.PetService;
import com.kristina.dogsrestapi.pet.model.Pet;
import com.kristina.dogsrestapi.schedule.model.Schedule;
import com.kristina.dogsrestapi.schedule.model.ScheduleDTO;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final EmployeeService employeeService;
    private final PetService petService;
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(EmployeeService employeeService, PetService petService, ScheduleRepository scheduleRepository) {
        this.employeeService = employeeService;
        this.petService = petService;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule save(ScheduleDTO scheduleDTO) {
        //vietoj ID passinti date.getweekday ir activity
        Employee employee = findAndCheckEmployee(scheduleDTO);
        Long petId = scheduleDTO.getPetId();
        Pet pet = petService.findPet(petId);
        return createAndSaveSchedule(scheduleDTO, employee, pet);
    }

    private Schedule createAndSaveSchedule(ScheduleDTO dto, Employee employee, Pet pet) {
        Schedule schedule = new Schedule();
        schedule.setDate(dto.getDate());
        schedule.setEmployee(employee);
        schedule.setPet(pet);
        schedule.setActivity(dto.getActivity());
        return scheduleRepository.save(schedule);
    }

    private Employee findAndCheckEmployee(ScheduleDTO scheduleDTO) {
        Long employeeId = scheduleDTO.getEmployeeId();
        Employee employee = employeeService.findEmployee(employeeId);
        checkEmployeeSkills(scheduleDTO, employee);
        checkEmployeeAvailability(scheduleDTO, employee);
        return employee;
    }

    private void checkEmployeeAvailability(ScheduleDTO scheduleDTO, Employee employee) {
        if (!employee.getDaysAvailable().contains(scheduleDTO.getDate().getDayOfWeek())) {
            throw new RuntimeException("Employee is not available");
        }
    }

    private void checkEmployeeSkills(ScheduleDTO scheduleDTO, Employee employee) {
        if (!employee.getSkills().contains(scheduleDTO.getActivity())) {
            throw new RuntimeException("Employee does not have required skills");
        }
    }
}
