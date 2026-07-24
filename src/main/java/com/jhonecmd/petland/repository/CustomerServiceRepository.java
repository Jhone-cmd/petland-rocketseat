package com.jhonecmd.petland.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonecmd.petland.model.customer_service.CustomerServiceEntity;
import com.jhonecmd.petland.model.customer_service.CustomerServiceStatus;
import com.jhonecmd.petland.model.customer_service.CustomerServiceType;

public interface CustomerServiceRepository extends JpaRepository<CustomerServiceEntity, Integer> {
    Optional<CustomerServiceEntity> findByStatus(CustomerServiceStatus status);

    Optional<CustomerServiceEntity> findByType(CustomerServiceType type);
}
