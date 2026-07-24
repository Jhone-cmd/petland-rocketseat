package com.jhonecmd.petland.service.customer_service;

import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.customer_service.CustomerServiceEntity;
import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;
import com.jhonecmd.petland.repository.CustomerServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteCustomerService_Service {

    private final CustomerServiceRepository customerServiceRepository;

    public void execute(Integer id) {
        CustomerServiceEntity entity = customerServiceRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Customer Service Not Found!"));
        customerServiceRepository.deleteById(entity.getId());
        return;
    }
}
