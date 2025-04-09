package com.sosfauna.sosfaunaBackend.model.entity;

import com.sosfauna.sosfaunaBackend.model.dto.DenunciaRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Table(name = "denuncias")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "Imagem é um campo obrigatório")
    @Column(name = "public_id", nullable = false, unique = true)
    private String publicId;

    @NotBlank(message = "Animal é um campo obrigatório")
    @Column(name = "animal", length = 50, nullable = false)
    @Size(max = 50)
    private String animal;

    @Column(name = "denunciado", length = 50)
    @Size(max = 50)
    private String denunciado;

    @NotBlank(message = "Descrição é um campo obrigatória")
    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @NotNull(message = "Data do ocorrido é um campo obrigatório")
    @Column(name = "data_ocorrido", nullable = false)
    private LocalDate dataOcorrido;

    @NotNull(message = "Hora do ocorrido é um campo  obrigatório")
    @Column(name = "hora_ocorrido", nullable = false)
    private LocalTime horaOcorrido;

    @NotBlank(message = "Bairro é um campo obrigatório")
    @Column(name = "bairro", length = 50, nullable = false)
    @Size(max = 50)
    private String bairro;

    @NotBlank(message = "Numero de endereço é um campo obrigatório")
    @Column(name = "numero", length = 10, nullable = false)
    @Size(max = 10)
    private String numero;

    @NotBlank(message = "Rua é um campo obrigatório")
    @Column(name = "rua", length = 50, nullable = false)
    @Size(max = 50)
    private String rua;

    @Column(name = "cep", length = 9)
    @Size(max = 9)
    private String cep;

    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_denuncia", nullable = false)
    private StatusDenuncia statusDenuncia = StatusDenuncia.ABERTO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orgao", nullable = true)
    private Orgao orgao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Denuncia() {}

    public Denuncia(String id, String publicId, String animal, String denunciado, String descricao,LocalDate dataOcorrido, LocalTime horaOcorrido, String bairro, String numero,String rua, String cep, LocalDateTime dataCriacao, StatusDenuncia statusDenuncia) {
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
