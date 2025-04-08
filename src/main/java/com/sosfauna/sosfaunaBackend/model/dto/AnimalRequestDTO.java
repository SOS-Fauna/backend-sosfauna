package com.sosfauna.animaladota1.dto;

import lombok.Data;

@Data
public class AnimalRequestDTO {
    private String especie;
    private String nome;
    private Integer idade;
    private String sexo;
}