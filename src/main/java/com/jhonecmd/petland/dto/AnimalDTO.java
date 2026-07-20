package com.jhonecmd.petland.dto;

import com.jhonecmd.petland.model.animal.AnimalSpecie;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnimalDTO {

    private String name;
    private String description;
    private AnimalSpecie specie;
    private LocalDate birthday;

}
