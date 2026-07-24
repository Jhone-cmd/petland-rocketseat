package com.jhonecmd.petland.service.register;

import org.springframework.stereotype.Service;

import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.register.RegisterEntity;
import com.jhonecmd.petland.repository.RegisterRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteRegisterService {

    private final RegisterRepository registerRepository;

    public void execute(Integer id) {

        RegisterEntity entity = registerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Register Not Found!"));
        registerRepository.deleteById(entity.getId());
        return;
    }
}
