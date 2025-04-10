package com.sosfauna.sosfaunaBackend.mappers;


import com.sosfauna.sosfaunaBackend.model.dto.OrgaoDto;
import com.sosfauna.sosfaunaBackend.model.entity.Orgao;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface OrgaoMapper {

    @Mapping(source = "animal", target = "animal")
    Orgao toOrgao(OrgaoDto orgaoDto);
    OrgaoDto toOrgaoDto(Orgao orgao);

}
