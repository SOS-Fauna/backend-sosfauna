package com.sosfauna.sosfaunaBackend.controller;


import com.sosfauna.sosfaunaBackend.model.dto.AnimalDto;
import com.sosfauna.sosfaunaBackend.model.dto.OrgaoDto;
import com.sosfauna.sosfaunaBackend.service.AnimalService;
import com.sosfauna.sosfaunaBackend.service.OrgaoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orgaos")
public class OrgaoController {


    private final OrgaoService orgaoService;
    private final AnimalService animalService;

    public OrgaoController(OrgaoService orgaoService, AnimalService animalService) {
        this.orgaoService = orgaoService;
        this.animalService = animalService;
    }

    @GetMapping("findAll")
    public ResponseEntity<List<OrgaoDto>> buscarTodos() {

        return ResponseEntity.ok().body(orgaoService.buscarTodos());
    }

    @GetMapping("findByCnpj/{cnpj}")
    public ResponseEntity<OrgaoDto> buscarPorCnpj(@PathVariable String cnpj) {
        return ResponseEntity.ok().body(orgaoService.buscarOrgaoPorCnpj(cnpj));
    }

    /*
    @GetMapping("findByEmail/{email}")
    public ResponseEntity<OrgaoDto> buscarEmail(@PathVariable String email) {
        return ResponseEntity.ok().body(orgaoService.buscarOrgaoPorCnpj(email));
    }
    */

    @PutMapping("updateById/{id}")
    public ResponseEntity<OrgaoDto> atualizarOrgao(@PathVariable String id, @RequestBody @Valid OrgaoDto dto ) {
        return ResponseEntity.status(HttpStatus.OK).body(orgaoService.atualizarOrgao(id,dto));
    }

    @PostMapping("/create")
    public ResponseEntity<OrgaoDto> cadastrar(@Valid @RequestBody OrgaoDto dto) {

        OrgaoDto orgao = orgaoService.cadastrarOrgao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orgao);
    }

    @PostMapping("create/animal")
    public ResponseEntity<AnimalDto> cadastrarAnimal(@RequestBody AnimalDto dto) {
        try {
            AnimalDto createdAnimal = animalService.cadastrarAnimal(dto);
            return new ResponseEntity<>(createdAnimal, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Void> deletarOrgao(@PathVariable String id) {
        orgaoService.deletarOrgao(id);
        return ResponseEntity.noContent().build();
    }

}