package com.jordan.avefenixapp.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jordan.avefenixapp.Dto.Anotacion.AnotacionRequestDTO;
import com.jordan.avefenixapp.Dto.Anotacion.AnotacionResponseDTO;
import com.jordan.avefenixapp.Service.AnotacionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/anotaciones")
@RequiredArgsConstructor
public class AnotacionController {

    private final AnotacionService anotacionService;

    @PostMapping
    public ResponseEntity<AnotacionResponseDTO> crear(
        @RequestBody AnotacionRequestDTO dto)
    {
        AnotacionResponseDTO respuesta = anotacionService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

}
