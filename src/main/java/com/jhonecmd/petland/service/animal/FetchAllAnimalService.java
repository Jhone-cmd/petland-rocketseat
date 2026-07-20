package com.jhonecmd.petland.service.animal;

import com.jhonecmd.petland.repository.AnimalRepository;
import org.springframework.stereotype.Service;

@Service
public class FetchAllAnimalService {

    private final AnimalRepository animalRepository;

    public FetchAllAnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void execute() {
        animalRepository.findAll();
    }
}
