package com.jhonecmd.petland.controller.animal;

import com.jhonecmd.petland.dto.AnimalDTO;
import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.model.register.RegisterEntity;
import com.jhonecmd.petland.service.animal.AnimalService;
import com.jhonecmd.petland.service.animal.FetchAllAnimalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
@AllArgsConstructor
public class AnimalController {

    private final AnimalService animalService;
    private  final FetchAllAnimalService fetchAllAnimalService;

    @PostMapping()
    public ResponseEntity<Object> createAnimal(@Valid @RequestBody AnimalDTO animalDTO) {
        try {
            var animalEntity = AnimalEntity.builder().name(animalDTO.getName()).description(animalDTO.getDescription()).specie(animalDTO.getSpecie()).birthday(animalDTO.getBirthday()).build();
            animalService.save(animalEntity);
            return  ResponseEntity.status(HttpStatus.CREATED).body(animalEntity.getId());

        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<AnimalEntity>> fetchAllAnimals() {
        return ResponseEntity.ok(fetchAllAnimalService.execute());
    }
}
