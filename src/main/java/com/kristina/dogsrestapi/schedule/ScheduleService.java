package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.schedule.model.Schedule;
import com.kristina.dogsrestapi.schedule.model.ScheduleDTO;

public interface ScheduleService {
    public Schedule save(ScheduleDTO scheduleDTO);
}
