package com.jhonecmd.petland.model.animal;

import com.jhonecmd.petland.model.register.FullAddress;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "animal")
@Data
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100)
    private String description;

    private LocalDate birthday;


}
