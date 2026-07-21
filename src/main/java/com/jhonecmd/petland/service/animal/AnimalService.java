package com.jhonecmd.petland.service.animal;

import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.repository.AnimalRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
       this.animalRepository = animalRepository;
   }

    public void save(AnimalEntity animalEntity) {
        animalRepository.save(animalEntity);

        return;
   }
}
