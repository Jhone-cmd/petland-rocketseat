package com.jhonecmd.petland.service.animal;

import com.jhonecmd.petland.dto.AnimalDTO;
import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.repository.AnimalRepository;
import com.jhonecmd.petland.utils.ObjectMapperEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateAnimalService {

    private final AnimalRepository animalRepository;
    private final ObjectMapperEntity objectMapperEntity;

    public AnimalEntity execute(Integer id, AnimalDTO request) {

        AnimalEntity entity = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Animal Not Found!"));
        objectMapperEntity.copyNonNullProperties(request, entity);
        return  animalRepository.save(entity);

    }
}
