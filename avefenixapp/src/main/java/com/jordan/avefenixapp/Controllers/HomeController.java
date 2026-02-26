package com.jordan.avefenixapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jordan.avefenixapp.Entities.UserEntity;
import com.jordan.avefenixapp.Service.UserService;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<UserEntity> index(){
        return userService.getAllUser();
    }

}
