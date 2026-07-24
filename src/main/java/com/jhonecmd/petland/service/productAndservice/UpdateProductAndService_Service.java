package com.jhonecmd.petland.service.productAndservice;

import org.springframework.stereotype.Service;

import com.jhonecmd.petland.dto.ProductAndServiceDTO;
import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;
import com.jhonecmd.petland.repository.ProductAndServiceRepository;
import com.jhonecmd.petland.utils.ObjectMapperEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateProductAndService_Service {

    private final ProductAndServiceRepository productAndServiceRepository;
    private final ObjectMapperEntity objectMapperEntity;

    public ProductAndServiceEntity execute(Integer id, ProductAndServiceDTO request) {
        ProductAndServiceEntity entity = productAndServiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product Or Service Not Found!"));
        objectMapperEntity.copyNonNullProperties(request, entity);
        return productAndServiceRepository.save(entity);
    }
}
