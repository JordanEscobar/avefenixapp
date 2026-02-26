package com.jordan.avefenixapp.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "User")
public class UserEntity {

    private Long id;
    private String name;
    private int age;
    private String email;
    private String password;

}
