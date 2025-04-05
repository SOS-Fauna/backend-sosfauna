package com.sosfauna.sosfaunaBackend.mappers;

import com.sosfauna.sosfaunaBackend.model.dto.DenunciaRequestDto;
import com.sosfauna.sosfaunaBackend.model.dto.DenunciaResponseDto;
import com.sosfauna.sosfaunaBackend.model.entity.Denuncia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DenunciaMapper {
    @Mapping(target = "orgao", ignore = true)
    @Mapping(target = "statusDenuncia", ignore = true)
    Denuncia transicao(DenunciaRequestDto dto, @MappingTarget Denuncia denuncia);


    @Mapping(target = "imagemUrl", ignore = true)
    @Mapping(target = "nomeOrgao", expression = "java(denuncia.getOrgao() != null ? denuncia.getOrgao().getNome() : null)")
    DenunciaResponseDto toResponseDto(Denuncia denuncia);
}
