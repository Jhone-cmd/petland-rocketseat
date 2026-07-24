package com.jhonecmd.petland.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonecmd.petland.model.animal.AnimalEntity;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {
    Optional<AnimalEntity> findByName(String name);
}
