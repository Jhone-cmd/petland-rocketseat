package com.jhonecmd.petland.service.productAndservice;

import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;
import com.jhonecmd.petland.repository.ProductAndServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchAllProductAndService_Service {

    private final ProductAndServiceRepository productAndServiceRepository;

    public FetchAllProductAndService_Service(ProductAndServiceRepository productAndServiceRepository) {
        this.productAndServiceRepository = productAndServiceRepository;
    }

    public List<ProductAndServiceEntity> execute() {
       return productAndServiceRepository.findAll();
    }
}
