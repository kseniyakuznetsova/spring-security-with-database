package com.kuznetsova.web.service;

import com.kuznetsova.web.model.User;
import com.kuznetsova.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void insertUser(User user) {
        String encodedPassword =  new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
}
