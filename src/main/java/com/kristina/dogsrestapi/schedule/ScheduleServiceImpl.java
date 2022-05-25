package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.employee.EmployeeService;
import com.kristina.dogsrestapi.employee.model.Employee;
import com.kristina.dogsrestapi.employee.model.EmployeeSkill;
import com.kristina.dogsrestapi.pet.PetService;
import com.kristina.dogsrestapi.pet.model.Pet;
import com.kristina.dogsrestapi.schedule.model.Schedule;
import com.kristina.dogsrestapi.schedule.model.ScheduleRequestDTO;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

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
    public Schedule save(ScheduleRequestDTO scheduleDTO) {
        Employee employee = findEmployeesAndCheckTheirAvailability(scheduleDTO);
        Long petId = scheduleDTO.getPetId();
        Pet pet = petService.findPet(petId);
        return createAndSaveSchedule(scheduleDTO, employee, pet);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getScheduleForPet(long petId) {
        return scheduleRepository.getByPetId(petId);
    }

    @Override
    public Schedule getScheduleForEmployee(long employeeId) {
        return scheduleRepository.getByEmployeeId(employeeId);
    }

    private Schedule createAndSaveSchedule(ScheduleRequestDTO dto, Employee employee, Pet pet) {
        Schedule schedule = new Schedule();
        schedule.setDate(dto.getDate());
        schedule.setEmployee(employee);
        schedule.setPet(pet);
        schedule.setActivity(dto.getActivity());
        return scheduleRepository.save(schedule);
    }

    private Employee findEmployeesAndCheckTheirAvailability(ScheduleRequestDTO scheduleDTO) {
        List<Employee> employees = employeeService.getAll();
        Employee employee = checkEmployeeAvailabilityAndSkills(scheduleDTO, employees).orElseThrow(() -> new RuntimeException("No available employees found"));
        return employee;
    }

    private Optional<Employee> checkEmployeeAvailabilityAndSkills(ScheduleRequestDTO scheduleDTO, List<Employee> employees) {
        DayOfWeek dayOfWeek = scheduleDTO.getDate().getDayOfWeek();
        return employees.stream().filter(employee -> checkEmployeeAvailability(employee, dayOfWeek))
                .filter(employee -> checkEmployeeSkills(employee, scheduleDTO.getActivity())).findFirst();
    }

    private Boolean checkEmployeeAvailability(Employee employee, DayOfWeek dayOfWeek) {
        if (!employee.getDaysAvailable().contains(dayOfWeek)) {
            throw new RuntimeException("Employee is not available");
        } else return true;
    }

    private Boolean checkEmployeeSkills(Employee employee, EmployeeSkill skill) {
        if (!employee.getSkills().contains(skill)) {
            throw new RuntimeException("Employee does not have required skills");
        } else return true;
    }
}
