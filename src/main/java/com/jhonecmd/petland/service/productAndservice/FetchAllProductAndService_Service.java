package com.jhonecmd.petland.service.productAndservice;

import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;
import com.jhonecmd.petland.repository.ProductAndServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FetchAllProductAndService_Service {

    private final ProductAndServiceRepository productAndServiceRepository;

    public List<ProductAndServiceEntity> execute() {
       return productAndServiceRepository.findAll();
    }
}
