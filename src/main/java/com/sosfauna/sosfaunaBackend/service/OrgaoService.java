package com.sosfauna.sosfaunaBackend.service;


import com.sosfauna.sosfaunaBackend.mappers.OrgaoMapper;
import com.sosfauna.sosfaunaBackend.model.dto.OrgaoDto;
import com.sosfauna.sosfaunaBackend.model.entity.Orgao;
import com.sosfauna.sosfaunaBackend.repository.OrgaoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;





@RequiredArgsConstructor
@Service
public class OrgaoService {


    private final OrgaoRepository orgaoRepository;
    private final OrgaoMapper orgaoMapper;


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

}






