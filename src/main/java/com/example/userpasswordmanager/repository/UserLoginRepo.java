package com.example.userpasswordmanager.repository;

import com.example.userpasswordmanager.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserLoginRepo extends JpaRepository<UserLogin,Integer> {
    Optional<UserLogin> findByUsername(String username);
}
