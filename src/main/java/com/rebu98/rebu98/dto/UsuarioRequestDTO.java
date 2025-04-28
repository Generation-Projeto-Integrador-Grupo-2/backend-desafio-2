package com.rebu98.rebu98.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(

        @NotBlank(message = "O nome é obrigatório!") String nome,

        @NotBlank(message = "O email é obrigatório!") @Email String email,

        @NotBlank(message = "A senha é obrigatória!") String senha,

        @NotBlank(message = "A foto é obrigatória!") String foto) {
}
