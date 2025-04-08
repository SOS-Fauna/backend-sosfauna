package com.sosfauna.animaladota1.controller;

import com.sosfauna.animaladota1.dto.AnimalRequestDTO;
import com.sosfauna.animaladota1.dto.AnimalResponseDTO;
import com.sosfauna.animaladota1.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalResponseDTO> criarAnimal(@RequestBody AnimalRequestDTO animalRequestDTO) {
        AnimalResponseDTO animalCriado = animalService.criarAnimal(animalRequestDTO);
        return new ResponseEntity<>(animalCriado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponseDTO>> listarAnimais() {
        List<AnimalResponseDTO> animais = animalService.listarAnimais();
        return new ResponseEntity<>(animais, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> buscarAnimalPorId(@PathVariable Long id) {
        try {
            AnimalResponseDTO animal = animalService.buscarAnimalPorId(id);
            return new ResponseEntity<>(animal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> atualizarAnimal(@PathVariable Long id, @RequestBody AnimalRequestDTO animalRequestDTO) {
        try {
            AnimalResponseDTO animalAtualizado = animalService.atualizarAnimal(id, animalRequestDTO);
            return new ResponseEntity<>(animalAtualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable Long id) {
        try {
            animalService.deletarAnimal(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}