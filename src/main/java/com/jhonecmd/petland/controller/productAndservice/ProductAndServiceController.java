package com.jhonecmd.petland.controller.productAndservice;

import com.jhonecmd.petland.dto.ProductAndServiceDTO;
import com.jhonecmd.petland.exceptions.ProductAndServiceNameAlreadyExists;
import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;
import com.jhonecmd.petland.service.productAndservice.ProductAndService_Service;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products-services")
public class ProductAndServiceController {

    private final ProductAndService_Service productAndService_Service;

    public ProductAndServiceController(ProductAndService_Service productAndService_Service) {
        this.productAndService_Service = productAndService_Service;
    }

    @PostMapping()
    public ResponseEntity<Object> addProductOrService(@Valid @RequestBody ProductAndServiceDTO productAndServiceDTO) {

        try {
            var productOrServiceEntity = ProductAndServiceEntity.builder().name(productAndServiceDTO.getName()).price(productAndServiceDTO.getPrice()).service(productAndServiceDTO.getService()).build();
            productAndService_Service.save(productOrServiceEntity);

            return  ResponseEntity.status(HttpStatus.CREATED).body(productOrServiceEntity.getId());

        } catch (ProductAndServiceNameAlreadyExists ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
