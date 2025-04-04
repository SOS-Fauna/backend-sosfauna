package com.sosfauna.sosfaunaBackend.mappers;


import com.sosfauna.sosfaunaBackend.model.dto.OrgaoDto;
import com.sosfauna.sosfaunaBackend.model.entity.Orgao;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrgaoMapper {

    Orgao toOrgao(OrgaoDto orgaoDto);
    OrgaoDto toOrgaoDto(Orgao orgao);

}
