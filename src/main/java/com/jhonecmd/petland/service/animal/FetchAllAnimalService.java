package com.jhonecmd.petland.service.animal;

import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchAllAnimalService {

    private final AnimalRepository animalRepository;

    public FetchAllAnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<AnimalEntity> execute() {
        return animalRepository.findAll();
    }
}
