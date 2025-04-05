package com.sosfauna.sosfaunaBackend.controller;


import com.sosfauna.sosfaunaBackend.model.dto.OrgaoDto;
import com.sosfauna.sosfaunaBackend.service.OrgaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("orgaos")
public class OrgaoController {


    private final OrgaoService orgaoService;

    public OrgaoController(OrgaoService orgaoService) {
        this.orgaoService = orgaoService;
    }

    @GetMapping("findAll")
    public ResponseEntity<List<OrgaoDto>> buscarTodos() {

        return ResponseEntity.ok().body(orgaoService.buscarTodos());
    }

    @GetMapping("findByCnpj/{cnpj}")
    public ResponseEntity<OrgaoDto> buscarPorCnpj(@PathVariable String cnpj) {
        return ResponseEntity.ok().body(orgaoService.buscarOrgaoPorCnpj(cnpj));
    }

    @PutMapping("updateById/{id}")
    public ResponseEntity<OrgaoDto> atualizarOrgao(@PathVariable String id, @RequestBody @Valid OrgaoDto dto ) {
        return ResponseEntity.status(HttpStatus.OK).body(orgaoService.atualizarOrgao(id,dto));
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Void> deletarOrgao(@PathVariable String id) {
        orgaoService.deletarOrgao(id);
        return ResponseEntity.noContent().build();
    }
}