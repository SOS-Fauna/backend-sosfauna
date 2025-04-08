package com.sosfauna.animaladota1.service;

import com.sosfauna.animaladota1.dto.AnimalRequestDTO;
import com.sosfauna.animaladota1.dto.AnimalResponseDTO;
import com.sosfauna.animaladota1.model.Animal;
import com.sosfauna.animaladota1.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public AnimalResponseDTO criarAnimal(AnimalRequestDTO animalRequestDTO) {
        Animal animal = new Animal();
        animal.setEspecie(animalRequestDTO.getEspecie());
        animal.setNome(animalRequestDTO.getNome());
        animal.setIdade(animalRequestDTO.getIdade());
        animal.setSexo(animalRequestDTO.getSexo());
        Animal animalSalvo = animalRepository.save(animal);
        return new AnimalResponseDTO(animalSalvo);
    }

    @Override
    public List<AnimalResponseDTO> listarAnimais() {
        List<Animal> animais = animalRepository.findAll();
        return animais.stream().map(AnimalResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public AnimalResponseDTO buscarAnimalPorId(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal não encontrado com o ID: " + id));
        return new AnimalResponseDTO(animal);
    }

    @Override
    public AnimalResponseDTO atualizarAnimal(Long id, AnimalRequestDTO animalRequestDTO) {
        Animal animalExistente = animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal não encontrado com o ID: " + id));

        animalExistente.setEspecie(animalRequestDTO.getEspecie());
        animalExistente.setNome(animalRequestDTO.getNome());
        animalExistente.setIdade(animalRequestDTO.getIdade());
        animalExistente.setSexo(animalRequestDTO.getSexo());

        Animal animalAtualizado = animalRepository.save(animalExistente);
        return new AnimalResponseDTO(animalAtualizado);
    }

    @Override
    public void deletarAnimal(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal não encontrado com o ID: " + id);
        }
        animalRepository.deleteById(id);
    }
}