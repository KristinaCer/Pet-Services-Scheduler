package com.kristina.dogsrestapi.schedule.model;

public final class ScheduleConverter {
    public static ScheduleResponseDTO toDTO (Schedule schedule){
        ScheduleResponseDTO dto = new ScheduleResponseDTO();
        dto.setDate(schedule.getDate());
        dto.setActivity(schedule.getActivity());
        dto.setEmployeeId(schedule.getId());
        dto.setPetId(schedule.getId());
        return dto;
    }
}
