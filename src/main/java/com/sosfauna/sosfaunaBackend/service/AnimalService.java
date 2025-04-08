package com.sosfauna.sosfaunaBackend.service;

import com.sosfauna.sosfaunaBackend.mappers.AnimalMapper;
import com.sosfauna.sosfaunaBackend.model.dto.AnimalDto;
import com.sosfauna.sosfaunaBackend.model.entity.Animal;
import com.sosfauna.sosfaunaBackend.model.entity.Orgao;
import com.sosfauna.sosfaunaBackend.repository.AnimalRepository;
import com.sosfauna.sosfaunaBackend.repository.OrgaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final OrgaoRepository orgaoRepository;
    private final AnimalMapper animalMapper;



    @Transactional
    public AnimalDto cadastrarAnimal(AnimalDto dto) {

        Orgao orgao = orgaoRepository.findByIdOrCnpj(dto.orgaoDtoId(),dto.cnpj())
                .orElseThrow(() -> new EntityNotFoundException("Órgão não encontrado com ID: " + dto.orgaoDtoId()));


        Animal animal = animalMapper.toAnimal(dto);
        animal.setOrgao(orgao);

        Animal savedAnimal = animalRepository.save(animal);
        return animalMapper.toAnimalDto(savedAnimal);
    }

    public List<AnimalDto> buscarTodos() {
        List<Animal> list = animalRepository.findAll();
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Não existe um animal cadastrado com este ID");
        }
        return list.stream().map(animalMapper::toAnimalDto).toList();
    }

    public AnimalDto buscarId(Long id) {
        Animal animalExistente = animalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID do animal não encontrado"));
        return animalMapper.toAnimalDto(animalExistente);
    }

    public AnimalDto alterarAnimal(Long id, AnimalDto dto) {
        Animal animalExistente = animalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Animal não encontrado."));
        Animal animal = animalMapper.toAnimal(dto);
        animal.setId(animalExistente.getId());
        return animalMapper.toAnimalDto(animalRepository.save(animal));
    }

    public void removerAnimal(Long id) {
        animalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Animal não encontrado."));
        animalRepository.deleteById(id);
    }

    public AnimalService(AnimalRepository animalRepository, OrgaoRepository orgaoRepository, AnimalMapper animalMapper) {
        this.animalRepository = animalRepository;
        this.orgaoRepository = orgaoRepository;
        this.animalMapper = animalMapper;
    }


}