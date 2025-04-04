package com.sosfauna.sosfaunaBackend.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orgaos")
public class Orgao {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false,unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String telefone;

    private String redeSocial;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String cep;

    //private byte[] foto_perfil; falta checar

    @Column(name = "acesso", nullable = false, columnDefinition = "boolean default true")
    private boolean acesso;

    @Column(nullable = false)
    private LocalDate dataCadastro = LocalDate.now();


}
