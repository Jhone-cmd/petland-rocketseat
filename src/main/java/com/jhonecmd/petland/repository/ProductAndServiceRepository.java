package com.jhonecmd.petland.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;

public interface ProductAndServiceRepository extends JpaRepository<ProductAndServiceEntity, Integer> {
    Optional<ProductAndServiceEntity> findByName(String name);
}
