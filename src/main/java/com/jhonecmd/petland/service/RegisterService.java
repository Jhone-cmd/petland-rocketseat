package com.jhonecmd.petland.service;

import com.jhonecmd.petland.model.Register;
import com.jhonecmd.petland.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public void save(Register register){
        registerRepository.save(register);
    }
}
