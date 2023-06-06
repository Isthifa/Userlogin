package com.example.userpasswordmanager.controller;

import com.example.userpasswordmanager.dto.PasswordDto;
import com.example.userpasswordmanager.dto.UserLoginDto;
import com.example.userpasswordmanager.entity.UserLogin;
import com.example.userpasswordmanager.repository.UserLoginRepo;
import com.example.userpasswordmanager.service.Services;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class UserController {

    private final Services services;


    private final UserLoginRepo userLoginRepo;

    public UserController(Services services, UserLoginRepo userLoginRepo) {
        this.services = services;
        this.userLoginRepo = userLoginRepo;
    }

    @PostMapping("/save")
    public void saveuser(@RequestBody UserLogin userLogin)
    {
        services.save(userLogin);
    }

    @PutMapping("/update")
    public String update(@RequestBody UserLoginDto userLoginDto)
    {
       services.updatePassword(userLoginDto.getUsername(),userLoginDto.getPassword());
       return "updated";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDto userLoginDto)
    {
        services.login(userLoginDto);
        return "login successfull";
    }
}
