package com.sosfauna.animaladota1.dto;

import com.sosfauna.animaladota1.model.Animal;
import lombok.Data;

@Data
public class AnimalResponseDTO {
    private Long id;
    private String especie;
    private String nome;
    private Integer idade;
    private String sexo;

    public AnimalResponseDTO(Animal animal) {
        this.id = animal.getId();
        this.especie = animal.getEspecie();
        this.nome = animal.getNome();
        this.idade = animal.getIdade();
        this.sexo = animal.getSexo();
    }
}
