package com.jhonecmd.petland.service.register;

import org.springframework.stereotype.Service;

import com.jhonecmd.petland.exceptions.RegisterAlreadyExists;
import com.jhonecmd.petland.model.register.RegisterEntity;
import com.jhonecmd.petland.repository.RegisterRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;

    public void save(RegisterEntity registerEntity) {

        registerRepository.findByEmail(registerEntity.getEmail()).ifPresent((register) -> {
            throw new RegisterAlreadyExists("Register Already Exists");
        });

        registerRepository.save(registerEntity);

        return;
    }

}
