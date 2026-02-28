package com.jordan.avefenixapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordan.avefenixapp.Entities.AnotacionEntity;
import com.jordan.avefenixapp.Repository.AnotacionRepository;

@Service
public class AnotacionServiceImpl  implements AnotacionService{
    @Autowired
    private AnotacionRepository anotacionRepository;

    public AnotacionServiceImpl(AnotacionRepository anotacionRepository) {
        this.anotacionRepository = anotacionRepository;
    }

    @Override
    public List<AnotacionEntity> getAnotacionesByUser(Long userId) {
        return anotacionRepository.findByUserId(userId);
    }

}
