package com.jhonecmd.petland.service.customer_service;

import com.jhonecmd.petland.model.customer_service.CustomerServiceEntity;
import com.jhonecmd.petland.repository.CustomerServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService_Service {

    private CustomerServiceRepository customerServiceRepository;

    public void save(CustomerServiceEntity customerServiceEntity) {
        customerServiceRepository.save(customerServiceEntity);
        return;
    }
}
