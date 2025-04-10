package com.sosfauna.sosfaunaBackend.mappers;


import com.sosfauna.sosfaunaBackend.model.dto.AnimalDto;
import com.sosfauna.sosfaunaBackend.model.dto.AnimalResponse;
import com.sosfauna.sosfaunaBackend.model.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    @Mapping(target = "orgao", ignore = true)
    Animal toAnimal(AnimalDto animalDto);

    Animal fromResponse(AnimalResponse response);
    AnimalDto toAnimalDto(Animal animal);
}
