package com.jhonecmd.petland.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "register")
@Data
public class Register {
    @Id
    private Integer id;

    @Column(length = 60, nullable = false)
    private String name;
}
