package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.schedule.model.Schedule;
import com.kristina.dogsrestapi.schedule.model.ScheduleConverter;
import com.kristina.dogsrestapi.schedule.model.ScheduleRequestDTO;
import com.kristina.dogsrestapi.schedule.model.ScheduleResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public ResponseEntity<Long> createSchedule(@RequestBody ScheduleRequestDTO scheduleDTO) {
        return new ResponseEntity<>(scheduleService.save(scheduleDTO).getId(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDTO>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        List<ScheduleResponseDTO> scheduleDTOS = schedules.stream().map(schedule -> ScheduleConverter.toDTO(schedule)).collect(Collectors.toList());
        return new ResponseEntity<>(scheduleDTOS, HttpStatus.OK);

    }

    @GetMapping("/pet/{petId}")
    public ResponseEntity<ScheduleResponseDTO> getScheduleForPet(@PathVariable long petId) {
        Schedule schedule = scheduleService.getScheduleForPet(petId);
        return new ResponseEntity<>(ScheduleConverter.toDTO(schedule), HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<ScheduleResponseDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        Schedule schedule = scheduleService.getScheduleForEmployee(employeeId);
        return new ResponseEntity<>(ScheduleConverter.toDTO(schedule), HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public Set<ScheduleRequestDTO> getScheduleForCustomer(@PathVariable long customerId) {
        throw new UnsupportedOperationException();
    }
}
