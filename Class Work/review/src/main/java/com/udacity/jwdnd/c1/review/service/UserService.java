package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.dtos.entity.User;

public interface UserService {

    boolean isUsernameAvailable(String username);

    int createUser(User user);

    String getCurrentSignedUserName();

    User getUser(String username);
}
