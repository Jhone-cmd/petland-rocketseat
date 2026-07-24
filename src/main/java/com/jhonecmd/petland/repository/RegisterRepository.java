package com.jhonecmd.petland.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonecmd.petland.model.register.RegisterEntity;

public interface RegisterRepository extends JpaRepository<RegisterEntity, Integer> {
    Optional<RegisterEntity> findByEmail(String email);
}
