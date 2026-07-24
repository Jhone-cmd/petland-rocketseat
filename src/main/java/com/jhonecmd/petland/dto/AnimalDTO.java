package com.jhonecmd.petland.dto;

import java.time.LocalDate;

import com.jhonecmd.petland.model.animal.AnimalSpecie;

import lombok.Data;

@Data
public class AnimalDTO {

    private String name;
    private String description;
    private AnimalSpecie specie;
    private LocalDate birthday;

}
