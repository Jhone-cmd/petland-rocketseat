package com.jhonecmd.petland.controller.register;

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

import com.jhonecmd.petland.dto.RegisterDTO;
import com.jhonecmd.petland.exceptions.RegisterAlreadyExists;
import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.register.RegisterEntity;
import com.jhonecmd.petland.service.register.DeleteRegisterService;
import com.jhonecmd.petland.service.register.FetchAllRegisterService;
import com.jhonecmd.petland.service.register.RegisterService;
import com.jhonecmd.petland.service.register.UpdateRegisterService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class RegisterController {

    private final RegisterService registerService;
    private final FetchAllRegisterService fetchAllRegisterService;
    private final UpdateRegisterService updateRegisterService;
    private final DeleteRegisterService deleteRegisterService;

    @PostMapping()
    public ResponseEntity<Object> register(@Valid @RequestBody RegisterDTO registerDTO) {

        try {
            var registerEntity = RegisterEntity.builder().name(registerDTO.getName()).email(registerDTO.getEmail())
                    .fullAddress(registerDTO.getFullAddress()).profile(registerDTO.getProfile()).build();
            registerService.save(registerEntity);

            return ResponseEntity.status(HttpStatus.CREATED).body(registerEntity.getId());

        } catch (RegisterAlreadyExists e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<RegisterEntity>> fetchAllRegisters() {
        return ResponseEntity.ok(fetchAllRegisterService.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProductOrService(@PathVariable Integer id,
            @RequestBody RegisterDTO registerDTO) {

        try {

            var entity = updateRegisterService.execute(id, registerDTO);
            return ResponseEntity.status(HttpStatus.OK).body(entity.getId());

        } catch (ResourceNotFound ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductOrService(@PathVariable Integer id) {

        try {

            deleteRegisterService.execute(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        } catch (ResourceNotFound ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
