package com.jordan.avefenixapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jordan.avefenixapp.Dto.UserRequestDTO;
import com.jordan.avefenixapp.Dto.UserResponseDTO;
import com.jordan.avefenixapp.Entities.UserEntity;
import com.jordan.avefenixapp.Repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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

    //crear usuario usando dto, y pass encriptada.
    @Override
    public UserResponseDTO createUser(UserRequestDTO request){
        UserEntity user = new UserEntity();
        user.setName(request.name());
        user.setAge(request.age());
        user.setEmail(request.email());

        //encriptar pass
        user.setPassword(passwordEncoder.encode(request.password()));
        UserEntity savedUser = userRepo.save(user);

        return new UserResponseDTO(
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getAge(),
            savedUser.getEmail()
        );
    }


}
