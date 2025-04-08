package com.sosfauna.sosfaunaBackend.service;


import com.sosfauna.sosfaunaBackend.mappers.AnimalMapper;
import com.sosfauna.sosfaunaBackend.mappers.OrgaoMapper;
import com.sosfauna.sosfaunaBackend.model.dto.OrgaoDto;
import com.sosfauna.sosfaunaBackend.model.entity.Animal;
import com.sosfauna.sosfaunaBackend.model.entity.Orgao;
import com.sosfauna.sosfaunaBackend.repository.OrgaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class OrgaoService {
    private final OrgaoRepository orgaoRepository;
    private final AnimalMapper animalMapper;
    private final OrgaoMapper orgaoMapper;

    @Transactional
    public OrgaoDto cadastrarOrgao(OrgaoDto dto) {
        orgaoRepository.findByCnpj(dto.cnpj()).ifPresent(orgao -> {
            throw new IllegalArgumentException("CNPJ já cadastrado");
        });

        Orgao orgao = orgaoMapper.toOrgao(dto);

        if (dto.animal() != null && !dto.animal().isEmpty()) {
            List<Animal> animais = dto.animal().stream()
                    .map(response -> {
                        Animal animal = animalMapper.fromResponse(response);
                        animal.setOrgao(orgao);
                        return animal;
                    })
                    .toList();

            orgao.setAnimal(animais);
        }
        Orgao savedOrgao = orgaoRepository.save(orgao);
        return orgaoMapper.toOrgaoDto(savedOrgao);

    }

    public List<OrgaoDto> buscarTodos() {
        List<Orgao> list = orgaoRepository.findAll();
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Não existe nenhum orgao");
        }
        return list.stream().map(orgaoMapper::toOrgaoDto).collect(Collectors.toList());
    }

    public OrgaoDto buscarOrgaoPorCnpj(String cnpj) {
        Orgao cnpjExistente = orgaoRepository.findByCnpj(cnpj).orElseThrow(() -> new IllegalArgumentException("Orgão não encontrado."));
        return orgaoMapper.toOrgaoDto(cnpjExistente);
    }

    /*  BUSCAR EMAIL
    public OrgaoDto buscarEmail(String email) {
        Orgao emailExistente = orgaoRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Email do orgão não encontrado."));
        return orgaoMapper.toOrgaoDto(emailExistente);
    }*/

    public OrgaoDto atualizarOrgao(String id, OrgaoDto dto) {
        Orgao orgaoExistente = orgaoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Orgão não encontrado."));
        Orgao orgao = orgaoMapper.toOrgao(dto);
        orgao.setId(orgaoExistente.getId());
        return orgaoMapper.toOrgaoDto(orgaoRepository.save(orgao));
    }

    public void deletarOrgao(String id) {
        orgaoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Orgão não encontrado."));
        orgaoRepository.deleteById(id);
    }

    public OrgaoService(OrgaoRepository orgaoRepository, AnimalMapper animalMapper, OrgaoMapper orgaoMapper) {
        this.orgaoRepository = orgaoRepository;
        this.animalMapper = animalMapper;
        this.orgaoMapper = orgaoMapper;
    }


}






