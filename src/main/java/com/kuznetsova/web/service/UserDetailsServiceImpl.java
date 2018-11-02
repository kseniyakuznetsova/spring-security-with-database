package com.kuznetsova.web.service;

import com.kuznetsova.web.model.User;
import com.kuznetsova.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //private UserRepository userRepository = new UserRepository();
    /*@Autowired
    private UserRepository userRepository;*/
    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username); //userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                roles
        );

        return userDetails;
    }
}
