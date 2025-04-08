package com.sosfauna.sosfaunaBackend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record AnimalDto(

        @JsonIgnore
        Long id,

        @NotBlank(message = "Especie obrigatório")
        @Size(max = 50, message = "A especie deve ter no maximo 50 caracteres")
        @Pattern(regexp = "\\d{20}", message = "A especie deve conter apenas letras")
        String especie,

        @NotBlank(message = "Especie obrigatório")
        @Size(max = 50, message = "O nome deve ter no maximo 50 caracteres")
        @Pattern(regexp = "\\d{20}", message = "A especie deve conter apenas letras")
        String nome,

        @NotNull(message = "Idade obrigatório")
        Integer idade,

        @NotBlank(message = "Especie obrigatório")
        @Pattern(regexp = "\\d{1}", message = "O sexo deve conter apenas 1 letra (M-macho / F-femea")
        String sexo,

        @NotNull(message = "Data Obrigatória")
        Date data_criacao,

        @JsonIgnore
        String orgaoDtoId,

        @NotNull(message = "CNPJ Obrigatório")
        String cnpj

) {
}
