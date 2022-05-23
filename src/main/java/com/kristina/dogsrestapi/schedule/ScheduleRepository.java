package com.kristina.dogsrestapi.schedule;

import com.kristina.dogsrestapi.schedule.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
