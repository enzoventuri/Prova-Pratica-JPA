package br.com.ctw.api_monitoramento_transformadores.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransformadorRequest(
        @NotNull(message = "Numero de Serie não pode ser nula!")
        String numeroSerie,

        @NotNull(message = "Modelo não pode ser nula!")
        String modelo,

        @NotNull(message = "Subestação não pode ser nula!")
        String subestacao,

        @NotNull(message = "Potência KVA não pode ser nula!")
        BigDecimal potenciaKva,

        @NotNull(message = "Limite de Temperatura do Óleo não pode ser nula!")
        BigDecimal limiteTemperaturaOleo,

        @NotNull(message = "Limite de Temperatura do Enrolamento não pode ser nula!")
        BigDecimal limiteTemperaturaEnrolamento
) {
}
