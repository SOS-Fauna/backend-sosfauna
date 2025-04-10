package com.sosfauna.sosfaunaBackend.model.dto;
import jakarta.validation.constraints.*;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;

public record UsuarioDto(@NotBlank(message = "CPF obrigatório")
                         @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 caracteres numéricos")
                         String cpf,

                         @NotBlank(message = "Nome obrigatório")
                         @Size(max = 50, message = "O nome deve ter no máximo 50 caracteres")
                         String nome,

                         @NotNull(message = "Data de nascimento obrigatória")
                         Date dataNascimento,

                         @NotBlank(message = "Telefone obrigatório")
                         @Pattern(regexp = "\\d{11}", message = "O telefone deve ter 11 dígitos numéricos")
                         String telefone,

                         // byte[] foto_perfil, ##falta ajustar

                         boolean acesso
                         // String id_usuario # ajeitar a FK.
)




{

}
