package com.jhonecmd.petland.service.register;

import com.jhonecmd.petland.model.register.RegisterEntity;
import com.jhonecmd.petland.repository.RegisterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FetchAllRegisterService {

    private final RegisterRepository registerRepository;

    public List<RegisterEntity> execute() {
        return registerRepository.findAll();
    }
}
