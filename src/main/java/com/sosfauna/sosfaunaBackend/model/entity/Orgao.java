package com.sosfauna.sosfaunaBackend.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orgaos")
public class Orgao  {


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

    public Orgao() {
    }

    // Construtor com todos os campos
    public Orgao(String id, String nome, String cnpj, String descricao, String telefone, String redeSocial, String rua, String numero, String bairro, String cidade, String cep, boolean acesso, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.telefone = telefone;
        this.redeSocial = redeSocial;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.acesso = acesso;
        this.dataCadastro = dataCadastro;
    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}



