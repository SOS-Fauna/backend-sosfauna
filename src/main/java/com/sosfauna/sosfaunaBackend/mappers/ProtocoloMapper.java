package com.sosfauna.sosfaunaBackend.mappers;

import com.sosfauna.sosfaunaBackend.model.dto.ProtocoloResponse;
import com.sosfauna.sosfaunaBackend.model.entity.Denuncia;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.swing.*;


@Mapper(componentModel = "spring")
public interface ProtocoloMapper {
    @Mapping(target = "protocolo", expression = "java(denuncia.getProtocolo())")
    @Mapping(target = "statusDenuncia",
            expression = "java(denuncia.getStatusDenuncia())")
    @Mapping(target = "telefoneOrgao", expression = "java(denuncia.getOrgao().getId())")
    @Mapping(target = "redeSocialOrgao", expression = "java(denuncia.getOrgao().getRedeSocial())")
    @Mapping(target = "nomeOrgao", expression = "java(denuncia.getOrgao().getNome())")
    ProtocoloResponse toResponseDto(Denuncia denuncia);
}

