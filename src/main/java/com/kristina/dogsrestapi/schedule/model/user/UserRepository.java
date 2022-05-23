package com.kristina.dogsrestapi.schedule.model.user;

import com.kristina.dogsrestapi.schedule.model.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
