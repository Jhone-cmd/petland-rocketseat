package com.jhonecmd.petland.service.register;

import com.jhonecmd.petland.model.register.RegisterEntity;
import com.jhonecmd.petland.repository.RegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchAllRegisterService {

    private final RegisterRepository registerRepository;

    public FetchAllRegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public List<RegisterEntity> execute() {
        return registerRepository.findAll();
    }
}
