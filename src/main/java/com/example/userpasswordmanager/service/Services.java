package com.example.userpasswordmanager.service;

import com.example.userpasswordmanager.dto.UserLoginDto;
import com.example.userpasswordmanager.entity.UserLogin;

public interface Services {

    void save(UserLogin userLogin);

    String login(UserLoginDto userLoginDto);


    String updatePassword(String username, String newPassword);
}
