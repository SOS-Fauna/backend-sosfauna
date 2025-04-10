package com.sosfauna.sosfaunaBackend.mappers;


import com.sosfauna.sosfaunaBackend.model.dto.DenunciaRequestDto;
import com.sosfauna.sosfaunaBackend.model.dto.DenunciaResponseDto;
import com.sosfauna.sosfaunaBackend.model.dto.ProtocoloResponse;
import com.sosfauna.sosfaunaBackend.model.entity.Denuncia;
import com.sosfauna.sosfaunaBackend.service.CloudinaryService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.lang.annotation.Target;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DenunciaMapper {
    @Mapping(target = "orgao", ignore = true)
    @Mapping(target = "statusDenuncia", ignore = true)
    Denuncia transicao(DenunciaRequestDto dto, @MappingTarget Denuncia denuncia);

    @Mapping(target = "imagemUrl", expression = "java(cloudinaryService.getImagemUrl(denuncia.getPublicId()))")
    @Mapping(target = "nomeOrgao", expression = "java(denuncia.getOrgao() != null ? denuncia.getOrgao().getNome() : null)")
    @Mapping(target = "idUsuario", expression = "java(denuncia.getUsuario() != null ? denuncia.getUsuario().getId() : null)")
    @Mapping(target = "idOrgao", expression = "java(denuncia.getOrgao() != null ? denuncia.getOrgao().getId() : null)")
    DenunciaResponseDto toResponseDto(Denuncia denuncia, @Context CloudinaryService cloudinaryService);

    List<DenunciaResponseDto> toResponseDto(List<Denuncia> denuncia,@Context CloudinaryService cloudinaryService );


}