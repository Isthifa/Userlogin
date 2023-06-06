package com.example.userpasswordmanager.service;

import com.example.userpasswordmanager.dto.UserLoginDto;
import com.example.userpasswordmanager.entity.UserLogin;
import com.example.userpasswordmanager.repository.UserLoginRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServicesImpl implements Services{


    private final UserLoginRepo userLoginRepo;

    public ServicesImpl(UserLoginRepo userLoginRepo) {
        this.userLoginRepo = userLoginRepo;
    }

    @Override
    public void save(UserLogin userLogin) {
        userLogin.setPassword(userLogin.getPassword());
        userLoginRepo.save(userLogin);
    }

    @Override
    public String login(UserLoginDto userLoginDto) {
        Optional<UserLogin> userLogin=userLoginRepo.findByUsername(userLoginDto.getUsername());
        if((userLogin.get().getPassword()).equals(userLoginDto.getPassword()))
        {
            System.out.println("success");
            return "User login successfull";
        }
        System.out.println(userLogin.get());
        return "invalid password";
    }

    public String updatePassword(String username, String newPassword) {
        Optional<UserLogin> optionalUserLogin = userLoginRepo.findByUsername(username);

        if (optionalUserLogin.isPresent()) {
            UserLogin userLogin = optionalUserLogin.get();
            String oldPassword = userLogin.getPassword();

            if (oldPassword.equals(newPassword)) {
                throw new RuntimeException("User password cannot be the same as the old password");
            } else {
                userLogin.setPassword(newPassword);
                userLoginRepo.save(userLogin);
            }

            return "Password updated successfully";
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
