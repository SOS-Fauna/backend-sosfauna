package com.sosfauna.sosfaunaBackend.mappers;

import com.sosfauna.sosfaunaBackend.model.dto.AnimalResponse;
import com.sosfauna.sosfaunaBackend.model.dto.OrgaoDto;
import com.sosfauna.sosfaunaBackend.model.entity.Animal;
import com.sosfauna.sosfaunaBackend.model.entity.Orgao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-10T04:45:01-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class OrgaoMapperImpl implements OrgaoMapper {

    @Override
    public Orgao toOrgao(OrgaoDto orgaoDto) {
        if ( orgaoDto == null ) {
            return null;
        }

        Orgao orgao = new Orgao();

        orgao.setAnimal( animalResponseListToAnimalList( orgaoDto.animal() ) );
        orgao.setPublicId( orgaoDto.publicId() );
        orgao.setEmail( orgaoDto.email() );
        orgao.setData_criacao( orgaoDto.data_criacao() );
        orgao.setNome( orgaoDto.nome() );
        orgao.setCnpj( orgaoDto.cnpj() );
        orgao.setDescricao( orgaoDto.descricao() );
        orgao.setTelefone( orgaoDto.telefone() );
        orgao.setRedeSocial( orgaoDto.redeSocial() );
        orgao.setRua( orgaoDto.rua() );
        orgao.setNumero( orgaoDto.numero() );
        orgao.setBairro( orgaoDto.bairro() );
        orgao.setCidade( orgaoDto.cidade() );
        orgao.setCep( orgaoDto.cep() );
        orgao.setAcesso( orgaoDto.acesso() );

        return orgao;
    }

    @Override
    public OrgaoDto toOrgaoDto(Orgao orgao) {
        if ( orgao == null ) {
            return null;
        }

        String nome = null;
        String cnpj = null;
        String descricao = null;
        String telefone = null;
        String redeSocial = null;
        String rua = null;
        String numero = null;
        String bairro = null;
        String cidade = null;
        String cep = null;
        boolean acesso = false;
        Date data_criacao = null;
        String email = null;
        String publicId = null;
        List<AnimalResponse> animal = null;

        nome = orgao.getNome();
        cnpj = orgao.getCnpj();
        descricao = orgao.getDescricao();
        telefone = orgao.getTelefone();
        redeSocial = orgao.getRedeSocial();
        rua = orgao.getRua();
        numero = orgao.getNumero();
        bairro = orgao.getBairro();
        cidade = orgao.getCidade();
        cep = orgao.getCep();
        acesso = orgao.isAcesso();
        data_criacao = orgao.getData_criacao();
        email = orgao.getEmail();
        publicId = orgao.getPublicId();
        animal = animalListToAnimalResponseList( orgao.getAnimal() );

        OrgaoDto orgaoDto = new OrgaoDto( nome, cnpj, descricao, telefone, redeSocial, rua, numero, bairro, cidade, cep, acesso, data_criacao, email, publicId, animal );

        return orgaoDto;
    }

    protected Animal animalResponseToAnimal(AnimalResponse animalResponse) {
        if ( animalResponse == null ) {
            return null;
        }

        Animal animal = new Animal();

        animal.setId( animalResponse.id() );
        animal.setEspecie( animalResponse.especie() );
        animal.setNome( animalResponse.nome() );
        animal.setIdade( animalResponse.idade() );
        animal.setSexo( animalResponse.sexo() );
        animal.setData_criacao( animalResponse.data_criacao() );

        return animal;
    }

    protected List<Animal> animalResponseListToAnimalList(List<AnimalResponse> list) {
        if ( list == null ) {
            return null;
        }

        List<Animal> list1 = new ArrayList<Animal>( list.size() );
        for ( AnimalResponse animalResponse : list ) {
            list1.add( animalResponseToAnimal( animalResponse ) );
        }

        return list1;
    }

    protected AnimalResponse animalToAnimalResponse(Animal animal) {
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

        AnimalResponse animalResponse = new AnimalResponse( id, especie, nome, idade, sexo, data_criacao );

        return animalResponse;
    }

    protected List<AnimalResponse> animalListToAnimalResponseList(List<Animal> list) {
        if ( list == null ) {
            return null;
        }

        List<AnimalResponse> list1 = new ArrayList<AnimalResponse>( list.size() );
        for ( Animal animal : list ) {
            list1.add( animalToAnimalResponse( animal ) );
        }

        return list1;
    }
}
