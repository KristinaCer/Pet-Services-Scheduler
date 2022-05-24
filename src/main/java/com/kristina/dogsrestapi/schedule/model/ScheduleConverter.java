package com.kristina.dogsrestapi.schedule.model;

public final class ScheduleConverter {
    public static ScheduleDTO toDto(Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setDate(schedule.getDate());
        return null;

    }
}
