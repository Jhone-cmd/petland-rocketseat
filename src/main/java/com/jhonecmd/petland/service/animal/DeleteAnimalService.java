package com.jhonecmd.petland.service.animal;

import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteAnimalService {

    private final AnimalRepository animalRepository;

    public void execute(Integer id) {

        AnimalEntity entity = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Animal Not Found!"));
        animalRepository.deleteById(entity.getId());
        return;

    }
}
