package com.udacity.jdnd.course1.service;

import com.udacity.jdnd.course1.entity.User;

public interface UserService {

    boolean isUsernameAvailable(String username);

    int createUser(User user);

    User getUser(String username);
}
