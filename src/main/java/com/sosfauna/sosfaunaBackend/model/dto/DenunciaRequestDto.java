package com.sosfauna.sosfaunaBackend.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;

public record DenunciaRequestDto(
        @NotNull(message = "O campo file é obrigatório") MultipartFile file,
        @NotBlank(message = "Campo animal é obrigatório")
        @Size(max = 50)  String animal,

        @Size(max = 50) String denunciado,

        @NotBlank(message = "O campo descricao é obrigatório")
        @Size(max = 255) String descricao,


        @NotNull LocalDate dataOcorrido,
        @NotNull LocalTime horaOcorrido,

        @NotBlank(message = "O campo bairro é obrigatório")
        @Size(max = 50) String bairro,

        @NotBlank(message = "O campo numero é obrigatório")
        @Size(max = 10) String numero,

        @NotBlank(message = "O campo rua é obrigatório")
        @Size(max = 50) String rua,

        @Pattern(regexp = "\\d{5}-?\\d{3}", message = "CEP inválido") String cep,

        @Nullable String idOrgao,

        @Nullable String nomeOrgao

){}
