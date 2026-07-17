package com.jhonecmd.petland.controller;

import com.jhonecmd.petland.dto.RegisterDTO;
import com.jhonecmd.petland.model.RegisterEntity;
import com.jhonecmd.petland.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {


    private final RegisterService registerService;

    public RegisterController (RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping()
    public ResponseEntity<Object> register(@RequestBody RegisterDTO registerDTO){

        var registerEntity = RegisterEntity.builder().name(registerDTO.getName()).email(registerDTO.getEmail()).fullAddress(registerDTO.getFullAddress()).profile(registerDTO.getProfile()).build();
        registerService.save(registerEntity);

        return  ResponseEntity.status(HttpStatus.CREATED).body(registerEntity.getId());
    }
}
