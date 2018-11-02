package com.kuznetsova.web.repository;

import com.kuznetsova.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Integer>{

    User findByUsername(String username);
}
