package com.jhonecmd.petland.controller.register;

import com.jhonecmd.petland.dto.RegisterDTO;
import com.jhonecmd.petland.exceptions.RegisterAlreadyExists;
import com.jhonecmd.petland.model.register.RegisterEntity;
import com.jhonecmd.petland.service.register.FetchAllRegisterService;
import com.jhonecmd.petland.service.register.RegisterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {


    private final RegisterService registerService;
    private final FetchAllRegisterService fetchAllRegisterService;

    public RegisterController (RegisterService registerService, FetchAllRegisterService fetchAllRegisterService) {
        this.registerService = registerService;
        this.fetchAllRegisterService = fetchAllRegisterService;
    }

    @PostMapping()
    public ResponseEntity<Object> register(@Valid @RequestBody RegisterDTO registerDTO){

        try {
            var registerEntity = RegisterEntity.builder().name(registerDTO.getName()).email(registerDTO.getEmail()).fullAddress(registerDTO.getFullAddress()).profile(registerDTO.getProfile()).build();
            registerService.save(registerEntity);

            return  ResponseEntity.status(HttpStatus.CREATED).body(registerEntity.getId());

        } catch (RegisterAlreadyExists e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<RegisterEntity>> fetchAllRegisters() {
        var registers = fetchAllRegisterService.execute();
        return ResponseEntity.ok(registers);
    }
}
