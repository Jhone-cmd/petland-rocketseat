package com.jhonecmd.petland.service.register;

import com.jhonecmd.petland.model.RegisterEntity;
import com.jhonecmd.petland.repository.RegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public void save(RegisterEntity registerEntity){
        registerRepository.save(registerEntity);
    }

    public List<RegisterEntity> fetchAllRegisters() {
        return registerRepository.findAll();
    }

}
