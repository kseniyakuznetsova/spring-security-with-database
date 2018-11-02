package com.kuznetsova.web.service;

import com.kuznetsova.web.model.User;

public interface UserService {
    User getUserByUsername(String username);
    void insertUser(User user);
}
