package com.jhonecmd.petland.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "register")
@Data
public class RegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    private Address address;

    @Enumerated(EnumType.STRING)
    private  Profile profile;
}
