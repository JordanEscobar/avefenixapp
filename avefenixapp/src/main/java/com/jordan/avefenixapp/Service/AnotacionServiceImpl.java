package com.jordan.avefenixapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jordan.avefenixapp.Dto.Anotacion.AnotacionRequestDTO;
import com.jordan.avefenixapp.Dto.Anotacion.AnotacionResponseDTO;
import com.jordan.avefenixapp.Entities.AnotacionEntity;
import com.jordan.avefenixapp.Entities.UserEntity;
import com.jordan.avefenixapp.Mapper.AnotacionMapper;
import com.jordan.avefenixapp.Repository.AnotacionRepository;
import com.jordan.avefenixapp.Repository.UserRepository;

@Service
public class AnotacionServiceImpl  implements AnotacionService{

    private final AnotacionRepository anotacionRepository;
    private final UserRepository userRepository;

    public AnotacionServiceImpl(AnotacionRepository anotacionRepository, UserRepository userRepository) {
        this.anotacionRepository = anotacionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<AnotacionEntity> getAnotacionesByUser(Long userId) {
        return anotacionRepository.findByUserId(userId);
    }

    @Transactional  
    public AnotacionResponseDTO crear(AnotacionRequestDTO dto)
    {
        UserEntity user = userRepository.findById(dto.userId()).
        orElseThrow( () -> new RuntimeException("Usuario no encontrado")); 
        
        AnotacionEntity anotacion = AnotacionMapper.toEntity(dto, user);

        anotacionRepository.save(anotacion);
        return AnotacionMapper.toDTO(anotacion);
    }

}
