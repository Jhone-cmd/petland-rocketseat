package com.jhonecmd.petland.service.animal;

import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public void save(AnimalEntity animalEntity) {
        animalRepository.save(animalEntity);
        return;
   }
}
