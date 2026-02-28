package com.jordan.avefenixapp.Service;

import java.util.List;

import com.jordan.avefenixapp.Entities.AnotacionEntity;

public interface AnotacionService {

    List<AnotacionEntity> getAnotacionesByUser(Long userId);

}
