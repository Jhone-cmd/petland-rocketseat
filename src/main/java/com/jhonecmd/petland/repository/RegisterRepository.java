package com.jhonecmd.petland.repository;

import com.jhonecmd.petland.model.register.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity, Integer> {
    Optional<RegisterEntity> findByEmail(String email);
}
