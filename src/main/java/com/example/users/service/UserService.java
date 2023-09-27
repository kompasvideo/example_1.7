package com.example.users.service;

import com.example.users.model.User;

public interface UserService {
    User saveUser(User userDto);
    User updateUser(long userId, User updateUser);
    User getUser(long userId);
    void deleteUser(long userId);
}
