package com.kristina.dogsrestapi;

import com.kristina.dogsrestapi.entity.Employee;
import com.kristina.dogsrestapi.entity.User;
import com.kristina.dogsrestapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DogsRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogsRestApiApplication.class, args);
    }

    //Is there a way the DB automatically assigns ids?
    @Bean
    CommandLineRunner initDB(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User(1L, "Anna Johns"));
            userRepository.save(new Employee("employee1", null, null));
            userRepository.save(new User(3L, "John Smith"));
            userRepository.save(new User(4L, "Lynn Johannes"));
            userRepository.save(new User(5L, "Ruth Berg"));
            userRepository.save(new Employee("employee2", null, null));

        };
    }

}
