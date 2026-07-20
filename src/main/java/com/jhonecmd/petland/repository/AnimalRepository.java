package com.jhonecmd.petland.repository;

import com.jhonecmd.petland.model.animal.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {
    Optional<AnimalEntity> findByName(String name);
}
