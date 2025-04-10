package com.sosfauna.sosfaunaBackend.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public record OrgaoDto(

        @NotBlank(message = "nome obrigatório")
        @Size(max = 100, message = "O nome deve ter no maximo 100 caracteres")
        String nome,

        @NotBlank(message = "CNPJ Obrigatório")
        @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 caracteres")
        String cnpj,

        @Size(max = 100, message = "A descrição deve ter no maximo 100 caracteres")
        String descricao,

        @NotBlank(message = "Telefone obrigatório")
        @Size(max = 100, message = "o telefone deve conter no maximo 11 caracteres")
        String telefone,

        @Size(max = 100, message = "A rede social deve conter no maximo 255 caracteres")
        String redeSocial,

        @NotBlank(message = "Endereço obrigatório")
        @Size(max = 100, message = "O endereço deve conter no maximo 50 caracteres")
        String rua,

        @NotBlank(message = "Numero da casa obrigatório")
        @Size(max = 100, message = "O endereço deve conter no maximo 10 caracteres")
        String numero,

        @NotBlank(message = "Bairro obrigatório")
        @Size(max = 100, message = "O endereço deve conter no maximo 30 caracteres")
        String bairro,

        @NotBlank(message = "Cidade obrigatório")
        @Size(max = 100, message = "O endereço deve conter no maximo 50 caracteres")
        String cidade,

        @NotBlank(message = "Cep obrigatório")
        @Size(max = 100, message = "O endereço deve conter no maximo 8 caracteres")
        String cep,

        // byte[] foto_perfil, ##falta ajustar

        @NotNull(message = "Acesso Obrigatório") //mutavel
        boolean acesso,

        Date data_criacao,

        String email,    //Adicionado
        String publicId, //Adicionado

        List<AnimalResponse> animal


) {
}
