package com.jordan.avefenixapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jordan.avefenixapp.Entities.AnotacionEntity;

public interface AnotacionRepository extends JpaRepository<AnotacionEntity, Long>{

    List<AnotacionEntity> findByUserId(Long userId);
}
