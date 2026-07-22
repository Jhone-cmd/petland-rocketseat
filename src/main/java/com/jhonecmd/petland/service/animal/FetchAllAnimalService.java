package com.jhonecmd.petland.service.animal;

import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FetchAllAnimalService {

    private final AnimalRepository animalRepository;

    public List<AnimalEntity> execute() {
        return animalRepository.findAll();
    }
}
