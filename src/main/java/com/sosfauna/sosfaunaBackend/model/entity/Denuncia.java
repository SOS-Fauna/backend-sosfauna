package com.sosfauna.sosfaunaBackend.model.entity;

import com.sosfauna.sosfaunaBackend.model.dto.DenunciaRequestDto;
import com.sosfauna.sosfaunaBackend.model.enumerated.StatusDenuncia;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "denuncias")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private String publicId;
    private String animal;
    private String denunciado;
    private String descricao;
    private LocalDate dataOcorrido;
    private LocalTime horaOcorrido;
    private String bairro;
    private String numero;
    private String rua;
    private String cep;

    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_denuncia", nullable = false)
    private StatusDenuncia statusDenuncia = StatusDenuncia.ABERTO;

    @Column(name = "protocolo", unique = true)
    @Size(max = 10)
    private String protocolo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orgao", nullable = true) //mudei de id_orgaos p orgaos_id
    private Orgao orgao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false) //mudei de id_usuario p usuario_id
    private Usuario usuario;

    public Denuncia() {}

    public Denuncia(String id, String publicId, String animal, String denunciado, String descricao,LocalDate dataOcorrido, LocalTime horaOcorrido, String bairro, String numero,String rua, String cep, LocalDateTime dataCriacao, StatusDenuncia statusDenuncia, String protocolo) {
        this.id = id;
        this.publicId = publicId;
        this.animal = animal;
        this.denunciado = denunciado;
        this.descricao = descricao;
        this.dataOcorrido = dataOcorrido;
        this.horaOcorrido = horaOcorrido;
        this.bairro = bairro;
        this.numero = numero;
        this.rua = rua;
        this.cep = cep;
        this.dataCriacao = dataCriacao;
        this.statusDenuncia = statusDenuncia;
        this.protocolo = protocolo;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getDenunciado() {
        return denunciado;
    }

    public void setDenunciado(String denunciado) {
        this.denunciado = denunciado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataOcorrido() {
        return dataOcorrido;
    }

    public void setDataOcorrido(LocalDate dataOcorrido) {
        this.dataOcorrido = dataOcorrido;
    }

    public LocalTime getHoraOcorrido() {
        return horaOcorrido;
    }

    public void setHoraOcorrido(LocalTime horaOcorrido) {
        this.horaOcorrido = horaOcorrido;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusDenuncia getStatusDenuncia() {
        return statusDenuncia;
    }

    public void setStatusDenuncia(StatusDenuncia statusDenuncia) {
        this.statusDenuncia = statusDenuncia;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

}
