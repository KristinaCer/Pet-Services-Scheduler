package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.schedule.model.Schedule;
import com.kristina.dogsrestapi.schedule.model.ScheduleRequestDTO;

import java.util.List;

public interface ScheduleService {
    Schedule save(ScheduleRequestDTO scheduleDTO);

    List<Schedule> getAllSchedules();

    Schedule getScheduleForPet(long petId);

    Schedule getScheduleForEmployee(long employeeId);
}
