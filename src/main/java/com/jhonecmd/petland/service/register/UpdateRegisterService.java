package com.jhonecmd.petland.service.register;

import com.jhonecmd.petland.dto.AnimalDTO;
import com.jhonecmd.petland.dto.RegisterDTO;
import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.model.register.RegisterEntity;
import com.jhonecmd.petland.repository.AnimalRepository;
import com.jhonecmd.petland.repository.RegisterRepository;
import com.jhonecmd.petland.utils.ObjectMapperEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateRegisterService {

    private final RegisterRepository registerRepository;
    private final ObjectMapperEntity objectMapperEntity;

    public RegisterEntity execute(Integer id, RegisterDTO request) {

        RegisterEntity entity = registerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Register Not Found!"));
        objectMapperEntity.copyNonNullProperties(request, entity);
        return registerRepository.save(entity);

    }
}
