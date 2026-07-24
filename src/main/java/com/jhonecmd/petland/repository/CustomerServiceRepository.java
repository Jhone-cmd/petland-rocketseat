package com.jhonecmd.petland.repository;

import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.model.customer_service.CustomerServiceEntity;
import com.jhonecmd.petland.model.customer_service.CustomerServiceStatus;
import com.jhonecmd.petland.model.customer_service.CustomerServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerServiceRepository extends JpaRepository<CustomerServiceEntity, Integer> {
    Optional<CustomerServiceEntity> findByStatus(CustomerServiceStatus status);
    Optional<CustomerServiceEntity> findByType(CustomerServiceType type);
}
