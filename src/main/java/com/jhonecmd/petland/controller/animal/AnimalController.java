package com.jhonecmd.petland.controller.animal;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonecmd.petland.dto.AnimalDTO;
import com.jhonecmd.petland.exceptions.ResourceNotFound;
import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.service.animal.AnimalService;
import com.jhonecmd.petland.service.animal.DeleteAnimalService;
import com.jhonecmd.petland.service.animal.FetchAllAnimalService;
import com.jhonecmd.petland.service.animal.UpdateAnimalService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/animals")
@AllArgsConstructor
public class AnimalController {

    private final AnimalService animalService;
    private final FetchAllAnimalService fetchAllAnimalService;
    private final UpdateAnimalService updateAnimalService;
    private final DeleteAnimalService deleteAnimalService;

    @PostMapping()
    public ResponseEntity<Object> createAnimal(@Valid @RequestBody AnimalDTO animalDTO) {
        try {
            var animalEntity = AnimalEntity.builder().name(animalDTO.getName()).description(animalDTO.getDescription())
                    .specie(animalDTO.getSpecie()).birthday(animalDTO.getBirthday()).build();
            animalService.save(animalEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(animalEntity.getId());

        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<AnimalEntity>> fetchAllAnimals() {
        return ResponseEntity.ok(fetchAllAnimalService.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProductOrService(@PathVariable Integer id, @RequestBody AnimalDTO animalDTO) {

        try {

            var entity = updateAnimalService.execute(id, animalDTO);
            return ResponseEntity.status(HttpStatus.OK).body(entity.getId());

        } catch (ResourceNotFound ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductOrService(@PathVariable Integer id) {

        try {

            deleteAnimalService.execute(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        } catch (ResourceNotFound ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
