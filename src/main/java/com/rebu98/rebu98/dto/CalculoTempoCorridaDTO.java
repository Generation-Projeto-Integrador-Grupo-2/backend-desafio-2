package com.rebu98.rebu98.dto;

import java.time.LocalDateTime;

public record CalculoTempoCorridaDTO(String origem, String destino, double tempoDeViagem,
        LocalDateTime tempoPrevistoChegada) {
}
