package com.sosfauna.sosfaunaBackend.mappers;

import com.sosfauna.sosfaunaBackend.model.dto.AnimalDto;
import com.sosfauna.sosfaunaBackend.model.dto.AnimalResponse;
import com.sosfauna.sosfaunaBackend.model.entity.Animal;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-08T17:37:48-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class AnimalMapperImpl implements AnimalMapper {

    @Override
    public Animal toAnimal(AnimalDto animalDto) {
        if ( animalDto == null ) {
            return null;
        }

        Animal animal = new Animal();

        animal.setId( animalDto.id() );
        animal.setEspecie( animalDto.especie() );
        animal.setNome( animalDto.nome() );
        animal.setIdade( animalDto.idade() );
        animal.setSexo( animalDto.sexo() );
        animal.setData_criacao( animalDto.data_criacao() );

        return animal;
    }

    @Override
    public Animal fromResponse(AnimalResponse response) {
        if ( response == null ) {
            return null;
        }

        Animal animal = new Animal();

        animal.setId( response.id() );
        animal.setEspecie( response.especie() );
        animal.setNome( response.nome() );
        animal.setIdade( response.idade() );
        animal.setSexo( response.sexo() );
        animal.setData_criacao( response.data_criacao() );

        return animal;
    }

    @Override
    public AnimalDto toAnimalDto(Animal animal) {
        if ( animal == null ) {
            return null;
        }

        Long id = null;
        String especie = null;
        String nome = null;
        Integer idade = null;
        String sexo = null;
        Date data_criacao = null;

        id = animal.getId();
        especie = animal.getEspecie();
        nome = animal.getNome();
        idade = animal.getIdade();
        sexo = animal.getSexo();
        data_criacao = animal.getData_criacao();

        String orgaoDtoId = null;
        String cnpj = null;

        AnimalDto animalDto = new AnimalDto( id, especie, nome, idade, sexo, data_criacao, orgaoDtoId, cnpj );

        return animalDto;
    }
}
