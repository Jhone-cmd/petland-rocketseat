package com.jhonecmd.petland.controller.customer_service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonecmd.petland.dto.CustomerServiceDTO;
import com.jhonecmd.petland.exceptions.ProductAndServiceNameAlreadyExists;
import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.customer_service.CustomerServiceEntity;
import com.jhonecmd.petland.service.customer_service.CustomerService_Service;
import com.jhonecmd.petland.service.customer_service.DeleteCustomerService_Service;
import com.jhonecmd.petland.service.customer_service.FetchAllCustomerService_Service;
import com.jhonecmd.petland.service.customer_service.UpdateCustomerService_Service;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("customer-services")
@AllArgsConstructor
public class CustomerServiceController {

    private final CustomerService_Service customerService_Service;
    private final FetchAllCustomerService_Service fetchAllCustomerService_Service;
    private final UpdateCustomerService_Service updateCustomerService_Service;
    private final DeleteCustomerService_Service deleteCustomerService_Service;

    @PostMapping()
    public ResponseEntity<Object> addProductOrService(@Valid @RequestBody CustomerServiceDTO customerServiceDTO) {

        try {
            var customerServiceEntity = CustomerServiceEntity.builder()
                    .description(customerServiceDTO.getDescription())
                    .date(customerServiceDTO.getDate()).time(customerServiceDTO.getTime())
                    .price(customerServiceDTO.getPrice()).emergency(customerServiceDTO.getEmergency())
                    .status(customerServiceDTO.getStatus()).type(customerServiceDTO.getType())
                    .client(customerServiceDTO.getClient()).animal(customerServiceDTO.getAnimal())
                    .service(customerServiceDTO.getService())
                    .build();

            customerService_Service.save(customerServiceEntity);

            return ResponseEntity.status(HttpStatus.CREATED).body(customerServiceEntity.getId());

        } catch (ProductAndServiceNameAlreadyExists ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<CustomerServiceEntity>> fetchAllProductsAndServices() {
        return ResponseEntity.ok(fetchAllCustomerService_Service.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProductOrService(@PathVariable Integer id,
            @RequestBody CustomerServiceDTO customerServiceDTO) {

        try {

            var entity = updateCustomerService_Service.execute(id, customerServiceDTO);
            return ResponseEntity.status(HttpStatus.OK).body(entity.getId());

        } catch (ResourceNotFound ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductOrService(@PathVariable Integer id) {

        try {

            deleteCustomerService_Service.execute(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        } catch (ResourceNotFound ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
