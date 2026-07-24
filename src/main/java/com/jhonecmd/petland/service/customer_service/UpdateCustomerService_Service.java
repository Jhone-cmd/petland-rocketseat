package com.jhonecmd.petland.service.customer_service;

import org.springframework.stereotype.Service;

import com.jhonecmd.petland.dto.CustomerServiceDTO;
import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.customer_service.CustomerServiceEntity;
import com.jhonecmd.petland.repository.CustomerServiceRepository;
import com.jhonecmd.petland.utils.ObjectMapperEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateCustomerService_Service {

    private final CustomerServiceRepository customerServiceRepository;
    private final ObjectMapperEntity objectMapperEntity;

    public CustomerServiceEntity execute(Integer id, CustomerServiceDTO request) {
        CustomerServiceEntity entity = customerServiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer Service Not Found!"));
        objectMapperEntity.copyNonNullProperties(request, entity);
        return customerServiceRepository.save(entity);
    }
}
