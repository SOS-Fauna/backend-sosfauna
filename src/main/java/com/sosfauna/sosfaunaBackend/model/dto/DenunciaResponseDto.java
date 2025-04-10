package com.sosfauna.sosfaunaBackend.model.dto;

import com.sosfauna.sosfaunaBackend.model.enumerated.StatusDenuncia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record DenunciaResponseDto(
        String id,
        String protocolo,
        String imagemUrl,
        String animal,
        String denunciado,
        String descricao,
        LocalDate dataOcorrido,
        LocalTime horaOcorrido,
        String bairro,
        String numero,
        String rua,
        String cep,
        String idOrgao,
        String idUsuario,
        String nomeOrgao,
        LocalDateTime dataCriacao,
        StatusDenuncia statusDenuncia

) {
}
