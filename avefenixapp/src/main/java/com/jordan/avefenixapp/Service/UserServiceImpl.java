package com.jordan.avefenixapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordan.avefenixapp.Entities.UserEntity;
import com.jordan.avefenixapp.Repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepo.findAll();
    }


}
