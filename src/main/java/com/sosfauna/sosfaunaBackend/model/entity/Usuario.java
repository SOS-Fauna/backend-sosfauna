package com.sosfauna.sosfaunaBackend.model.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true, length = 50)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = false)
    private String telefone;

    //private byte[] foto_perfil; falta checar

    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(nullable = false)
    private boolean acesso;

    String email;

    public Usuario() {
    }


    public Usuario(String id, String cpf, String nome, Date dataNascimento, String telefone, LocalDateTime dataCriacao, boolean acesso, String email) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.dataCriacao = dataCriacao;
        this.acesso = acesso;
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.id = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }

    // Método adicional para o campo foto_perfil, caso seja necessário
    // public byte[] getFotoPerfil() {
    //     return foto_perfil;
    // }

    // public void setFotoPerfil(byte[] fotoPerfil) {
    //     this.foto_perfil = fotoPerfil;
    // }

    // Relacionamento com UsuarioLogin, se necessário
    /* public UsuarioLogin getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(UsuarioLogin usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    } */


    /*@ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioLogin usuarioLogin;
    precisa de reparo
     */
}
