package com.jordan.avefenixapp.Service;

import java.util.List;

import com.jordan.avefenixapp.Dto.UserRequestDTO;
import com.jordan.avefenixapp.Dto.UserResponseDTO;
import com.jordan.avefenixapp.Entities.UserEntity;

public interface UserService {

    List<UserEntity> getAllUser();

    List<UserResponseDTO> getAllUserDTOs();
    UserResponseDTO createUser(UserRequestDTO request);

}
