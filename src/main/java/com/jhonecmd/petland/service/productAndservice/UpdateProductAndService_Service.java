package com.jhonecmd.petland.service.productAndservice;

import com.jhonecmd.petland.dto.ProductAndServiceDTO;
import com.jhonecmd.petland.exceptions.RegisterAlreadyExists;
import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;
import com.jhonecmd.petland.repository.ProductAndServiceRepository;
import com.jhonecmd.petland.utils.ObjectMapperEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateProductAndService_Service {

    private final ProductAndServiceRepository productAndServiceRepository;
    private final ObjectMapperEntity objectMapperEntity;

    public ProductAndServiceEntity execute(Integer id, ProductAndServiceDTO request) {
       ProductAndServiceEntity entity = productAndServiceRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Product Or Service Not Found!"));
       objectMapperEntity.copyNonNullProperties(request, entity);
       return productAndServiceRepository.save(entity);
    }
}
