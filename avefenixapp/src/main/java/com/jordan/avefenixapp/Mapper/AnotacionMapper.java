package com.jordan.avefenixapp.Mapper;

import com.jordan.avefenixapp.Dto.Anotacion.AnotacionRequestDTO;
import com.jordan.avefenixapp.Dto.Anotacion.AnotacionResponseDTO;
import com.jordan.avefenixapp.Entities.AnotacionEntity;
import com.jordan.avefenixapp.Entities.UserEntity;

public class AnotacionMapper {


    //entity -> response dto
    public static AnotacionResponseDTO toDTO(AnotacionEntity anotacionEntity){
        return new AnotacionResponseDTO(
            anotacionEntity.getId_anotacion(),
            anotacionEntity.getDescripcion(),
            anotacionEntity.getFecha(),
            anotacionEntity.getUser().getId()
        );
    }

    //request dto -> entity
    public static AnotacionEntity toEntity(AnotacionRequestDTO dto, UserEntity user)
    {
        AnotacionEntity anotacion = new AnotacionEntity();
        anotacion.setDescripcion(dto.descripcion());
        anotacion.setFecha(dto.fecha());
        anotacion.setUser(user);
        return anotacion;
    }





}
