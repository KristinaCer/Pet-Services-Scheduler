package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.schedule.model.ScheduleDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {


    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Set<Long> employeeIds = scheduleDTO.getEmployeeIds();

        Set<Long> petIds = scheduleDTO.getPetIds();

        scheduleService.save(scheduleDTO.getDate(), employeeIds, petIds, scheduleDTO.getActivities());

        return null;
    }

    @GetMapping
    public Set<ScheduleDTO> getAllSchedules() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/pet/{petId}")
    public Set<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/employee/{employeeId}")
    public Set<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/customer/{customerId}")
    public Set<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        throw new UnsupportedOperationException();
    }
}
