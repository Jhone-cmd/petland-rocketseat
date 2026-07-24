package com.jhonecmd.petland.service.productAndservice;

import org.springframework.stereotype.Service;

import com.jhonecmd.petland.exceptions.ProductAndServiceNameAlreadyExists;
import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;
import com.jhonecmd.petland.repository.ProductAndServiceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductAndService_Service {

    private final ProductAndServiceRepository productAndServiceRepository;

    public void save(ProductAndServiceEntity productAndServiceEntity) {
        productAndServiceRepository.findByName(productAndServiceEntity.getName()).ifPresent((productAndServiceName) -> {
            throw new ProductAndServiceNameAlreadyExists("The Product or Service already Exists!");
        });

        productAndServiceRepository.save(productAndServiceEntity);

        return;
    }
}
