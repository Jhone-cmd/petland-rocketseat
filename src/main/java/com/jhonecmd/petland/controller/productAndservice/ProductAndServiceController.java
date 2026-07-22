package com.jhonecmd.petland.controller.productAndservice;

import com.jhonecmd.petland.dto.ProductAndServiceDTO;
import com.jhonecmd.petland.exceptions.ProductAndServiceNameAlreadyExists;
import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;
import com.jhonecmd.petland.service.productAndservice.DeleteProductAndService_Service;
import com.jhonecmd.petland.service.productAndservice.FetchAllProductAndService_Service;
import com.jhonecmd.petland.service.productAndservice.ProductAndService_Service;
import com.jhonecmd.petland.service.productAndservice.UpdateProductAndService_Service;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products-services")
@AllArgsConstructor
public class ProductAndServiceController {

    private final ProductAndService_Service productAndService_Service;
    private final FetchAllProductAndService_Service fetchAllProductAndService_Service;
    private final UpdateProductAndService_Service updateProductAndService_service;
    private final DeleteProductAndService_Service deleteProductAndService_Service;

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

    @GetMapping()
    public ResponseEntity<List<ProductAndServiceEntity>> fetchAllProductsAndServices() {
       return ResponseEntity.ok(fetchAllProductAndService_Service.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProductOrService(@PathVariable Integer id, @RequestBody ProductAndServiceDTO productAndServiceDTO) {

        try {

            var entity = updateProductAndService_service.execute(id, productAndServiceDTO);
            return  ResponseEntity.status(HttpStatus.OK).body(entity.getId());

        } catch (ResourceNotFound ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductOrService(@PathVariable Integer id) {

        try {

            deleteProductAndService_Service.execute(id);
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        } catch (ResourceNotFound ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
