package com.sosfauna.sosfaunaBackend.controller;

import com.sosfauna.sosfaunaBackend.model.dto.AnimalDto;
import com.sosfauna.sosfaunaBackend.service.AnimalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/animais")
public class AnimalController {


    private final AnimalService animalService;

    @GetMapping("findAll")
    public ResponseEntity<List<AnimalDto>> buscarTodos() {
        return ResponseEntity.ok().body(animalService.buscarTodos());
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<AnimalDto> buscarAnimalPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(animalService.buscarId(id));
    }

    @PutMapping("updateById/{id}")
    public ResponseEntity<AnimalDto> alterarAnimal(@PathVariable Long id, @RequestBody @Valid AnimalDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(animalService.alterarAnimal(id, dto));
    }

    @PostMapping("/create")
    public ResponseEntity<AnimalDto> cadastrarAnimal(@RequestBody @Valid AnimalDto dto) {
        AnimalDto animal = animalService.cadastrarAnimal(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(animal);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Void> removerAnimal(@PathVariable Long id) {
        animalService.removerAnimal(id);
        return ResponseEntity.noContent().build();
    }
}