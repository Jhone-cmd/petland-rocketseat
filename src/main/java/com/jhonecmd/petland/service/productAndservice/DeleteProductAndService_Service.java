package com.jhonecmd.petland.service.productAndservice;

import com.jhonecmd.petland.dto.ProductAndServiceDTO;
import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;
import com.jhonecmd.petland.repository.ProductAndServiceRepository;
import com.jhonecmd.petland.utils.ObjectMapperEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProductAndService_Service {

    private final ProductAndServiceRepository productAndServiceRepository;

    public void execute(Integer id) {

        ProductAndServiceEntity entity = productAndServiceRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Product Or Service Not Found!"));
        productAndServiceRepository.deleteById(entity.getId());
        return;
    }
}
