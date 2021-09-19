package com.kristina.dogsrestapi.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository <Schedule, Long>{
}
