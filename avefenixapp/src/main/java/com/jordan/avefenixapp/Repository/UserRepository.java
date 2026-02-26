package com.jordan.avefenixapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jordan.avefenixapp.Entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
