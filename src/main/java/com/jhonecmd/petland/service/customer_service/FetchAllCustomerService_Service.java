package com.jhonecmd.petland.service.customer_service;

import com.jhonecmd.petland.model.customer_service.CustomerServiceEntity;
import com.jhonecmd.petland.repository.CustomerServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FetchAllCustomerService_Service {

    private CustomerServiceRepository customerServiceRepository;

    public List<CustomerServiceEntity> execute() {
        return customerServiceRepository.findAll();
     }
}
