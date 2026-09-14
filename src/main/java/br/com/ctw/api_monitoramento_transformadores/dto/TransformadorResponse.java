package br.com.ctw.api_monitoramento_transformadores.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransformadorResponse(
        Long id,
        String numeroSerie,
        String modelo,
        String subestacao,
        BigDecimal potenciaKva,
        BigDecimal limiteTemperaturaOleo,
        BigDecimal limiteTemperaturaEnrolamento
) {
}
