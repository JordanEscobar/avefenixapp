package com.jordan.avefenixapp.Service;

import java.util.List;

import com.jordan.avefenixapp.Dto.Anotacion.AnotacionRequestDTO;
import com.jordan.avefenixapp.Dto.Anotacion.AnotacionResponseDTO;
import com.jordan.avefenixapp.Entities.AnotacionEntity;

public interface AnotacionService {

    List<AnotacionEntity> getAnotacionesByUser(Long userId);
    AnotacionResponseDTO crear(AnotacionRequestDTO dto);

}
