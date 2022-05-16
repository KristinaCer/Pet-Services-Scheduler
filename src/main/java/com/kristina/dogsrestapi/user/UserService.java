package com.kristina.dogsrestapi.user;

import com.kristina.dogsrestapi.user.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
}
