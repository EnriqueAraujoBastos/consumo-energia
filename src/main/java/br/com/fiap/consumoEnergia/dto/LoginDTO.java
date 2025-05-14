package br.com.fiap.consumoEnergia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDTO (
        @NotBlank(message = "O e-mail do usuário é obrigatório!")
        @Email(message = "O e-mail do usuário não é válido!")
        String email,

        @NotBlank(message = "A senha é obrigatório")
        @Size(min = 8, max = 16, message = "A senha deve conter entre 8 e 16 caracteres")
        String senha
) {

}
