package com.jhonecmd.petland.service.register;

import org.springframework.stereotype.Service;

import com.jhonecmd.petland.dto.RegisterDTO;
import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.register.RegisterEntity;
import com.jhonecmd.petland.repository.RegisterRepository;
import com.jhonecmd.petland.utils.ObjectMapperEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateRegisterService {

    private final RegisterRepository registerRepository;
    private final ObjectMapperEntity objectMapperEntity;

    public RegisterEntity execute(Integer id, RegisterDTO request) {

        RegisterEntity entity = registerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Register Not Found!"));
        objectMapperEntity.copyNonNullProperties(request, entity);
        return registerRepository.save(entity);

    }
}
