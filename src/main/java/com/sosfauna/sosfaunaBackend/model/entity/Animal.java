package com.sosfauna.sosfaunaBackend.model.entity;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "animais_adocao")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false)
    private Date data_criacao = new Date();

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "orgaos_id",referencedColumnName = "id", nullable = false)
    private Orgao orgao;

    public Animal() {
    }

    public Animal(Long id, String especie, String nome, Integer idade, String sexo, Date data_criacao, Orgao orgao) {
        this.id = id;
        this.especie = especie;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.data_criacao = data_criacao;
        this.orgao = orgao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }
}