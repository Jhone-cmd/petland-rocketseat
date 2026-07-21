package com.jhonecmd.petland.model.productAndservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductAndServiceRepository extends JpaRepository<ProductAndServiceEntity, Integer> {
    Optional<ProductAndServiceEntity> findByName(String name);
}
