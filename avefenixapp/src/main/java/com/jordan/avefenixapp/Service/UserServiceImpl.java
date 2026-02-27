package com.jordan.avefenixapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordan.avefenixapp.Dto.UserResponseDTO;
import com.jordan.avefenixapp.Entities.UserEntity;
import com.jordan.avefenixapp.Repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
//sin dto, muestra directo lo de la db, no es recomendado.
    @Override
    public List<UserEntity> getAllUser() {
        return userRepo.findAll();
    }
//usando dto, muestra solo lo que se necesita, recomendado.
    @Override
    public List<UserResponseDTO> getAllUserDTOs() {
        return userRepo.findAll().stream()
        .map(user -> new UserResponseDTO(
            user.getId(),
            user.getName(),
            user.getAge(),
            user.getEmail()
        ))
        .toList();
    }


}
