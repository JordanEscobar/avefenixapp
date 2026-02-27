package com.jordan.avefenixapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jordan.avefenixapp.Dto.UserRequestDTO;
import com.jordan.avefenixapp.Dto.UserResponseDTO;
import com.jordan.avefenixapp.Entities.UserEntity;
import com.jordan.avefenixapp.Service.UserService;


@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    //controlador directo mostrando lo que hay en la bd, no es recomendado.
    @GetMapping("/")
    public List<UserEntity> index(){
        return userService.getAllUser();
    }
//controlador usando dto, mostrando solo lo que se necesita, recomendado.
    @GetMapping("/dto")
    public ResponseEntity<List<UserResponseDTO>> indexDTO(){
        return ResponseEntity.ok(userService.getAllUserDTOs());
    }

    //controllador usando dto, para agregar un nuevo user.@GetMapping("path")
    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO request){
        UserResponseDTO user = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    

}
