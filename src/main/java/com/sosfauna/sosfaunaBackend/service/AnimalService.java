package com.sosfauna.animaladota1.service;

import com.sosfauna.animaladota1.dto.AnimalRequestDTO;
import com.sosfauna.animaladota1.dto.AnimalResponseDTO;
import java.util.List;

public interface AnimalService {
    AnimalResponseDTO criarAnimal(AnimalRequestDTO animalRequestDTO);
    List<AnimalResponseDTO> listarAnimais();
    AnimalResponseDTO buscarAnimalPorId(Long id);
    AnimalResponseDTO atualizarAnimal(Long id, AnimalRequestDTO animalRequestDTO);
    void deletarAnimal(Long id);
}
