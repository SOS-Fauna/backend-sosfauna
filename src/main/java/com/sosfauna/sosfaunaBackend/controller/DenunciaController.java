package com.sosfauna.sosfaunaBackend.controller;

import com.sosfauna.sosfaunaBackend.model.dto.DenunciaRequestDto;
import com.sosfauna.sosfaunaBackend.model.dto.DenunciaResponseDto;
import com.sosfauna.sosfaunaBackend.model.dto.ProtocoloResponse;
import com.sosfauna.sosfaunaBackend.service.CloudinaryService;
import com.sosfauna.sosfaunaBackend.service.DenunciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/denuncias")
public class DenunciaController {
    @Autowired
    private DenunciaService denunciaService;
    private CloudinaryService cloudinaryService;

    public DenunciaController(DenunciaService denunciaService, CloudinaryService cloudinaryService){
        this.denunciaService = denunciaService;
        this.cloudinaryService = cloudinaryService;
    }



    @PostMapping("criar")
    public ResponseEntity<DenunciaResponseDto> criar(@ModelAttribute @Valid DenunciaRequestDto dto) {
        DenunciaResponseDto response = denunciaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/minhas")
    public ResponseEntity<List<DenunciaResponseDto>> listarMinhas() {
        return ResponseEntity.ok(denunciaService.listarMinhasDenuncias());
    }


    @GetMapping("/pendentes")
    public ResponseEntity<List<DenunciaResponseDto>> listarPendentes() {
        return ResponseEntity.ok(denunciaService.listarPendentes());
    }


    @GetMapping("/aceitas")
    public ResponseEntity<List<DenunciaResponseDto>> listarAceitas() {
        return ResponseEntity.ok(denunciaService.listarAceitas());
    }

    //Liberar Rota
//    @GetMapping("/protocolo/{protocolo}")
//    public ResponseEntity<DenunciaResponseDto> buscarPorProtocolo(@PathVariable String protocolo) {
//        DenunciaResponseDto dto = denunciaService.buscarProtocolo(protocolo);
//        return ResponseEntity.ok(dto);
//    }

    @GetMapping("/protocolo/{protocolo}")
    public ResponseEntity<ProtocoloResponse> buscarPorProtocolo(@PathVariable String protocolo) {
        ProtocoloResponse dto = denunciaService.buscarProtocolo(protocolo);
        return ResponseEntity.ok(dto);
    }


    @PatchMapping("/{id}/aceitar")
    public ResponseEntity<Void> aceitarDenuncia(@PathVariable("id") String idDenuncia) {
        denunciaService.aceitarDenuncia(idDenuncia);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/concluir/{idDenuncia}")
    public ResponseEntity<String> concluirDenuncia(@PathVariable String idDenuncia) {
        try {
            denunciaService.concluirDenuncia(idDenuncia);
            return ResponseEntity.ok("Denúncia concluída com sucesso.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{idDenuncia}")
    public ResponseEntity<String> deletarDenuncia(@PathVariable String idDenuncia) {
        try {
            denunciaService.deletarDenuncia(idDenuncia);
            return ResponseEntity.ok("Denúncia deletada com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}