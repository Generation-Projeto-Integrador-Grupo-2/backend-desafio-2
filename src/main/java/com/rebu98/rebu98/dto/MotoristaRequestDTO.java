package com.rebu98.rebu98.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MotoristaRequestDTO(

        @NotBlank(message = "cnh é obrigatória!") @Size(min = 3, max = 100,
                message = "O tamanho mínimo da CNH é de 3 e máximo de 100 caracteres") String cnh,

        @NotBlank(message = "modelo do carro é obrigatório!") @Size(min = 3, max = 100,
                message = "O tamanho mínimo do modelo do carro é de 3 e máximo de 100 caracteres!") String modeloCarro,

        @NotBlank(message = "placa é obrigatória!") @Size(min = 3, max = 100) String placa) {
}
