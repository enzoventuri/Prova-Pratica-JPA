package br.com.ctw.api_monitoramento_transformadores.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * Exemplo de Entrada:
 * <br>
 * {<br>
 *         "numeroSerie": "TRF-2026-1004",
 *         <br>
 *         "modelo": "Transformador Trifásico de Força 15MVA",
 *         <br>
 *         "subestacao": "Subestação Central - Setor A",
 *         <br>
 *         "potenciaKva": 15000.00,
 *         <br>
 *         "limiteTemperaturaOleo": 85.00,
 *         <br>
 *         "limiteTemperaturaEnrolamento": 105.00
 *         <br>
 * }
 * @param numeroSerie Número de Série do Transformador
 * @param modelo Modelo do Transformador
 * @param subestacao Subestação do Transformador
 * @param potenciaKva Potência em KVA do Transformador
 * @param limiteTemperaturaOleo Limite de Temperatura do Óleo do Transformador
 * @param limiteTemperaturaEnrolamento Limite de Temperatura do Enrolamento do Transformador
 */
public record TransformadorRequest(
        @NotNull(message = "Numero de Serie não pode ser nula!")
        String numeroSerie,

        @NotNull(message = "Modelo não pode ser nula!")
        String modelo,

        @NotNull(message = "Subestação não pode ser nula!")
        String subestacao,

        @NotNull(message = "Potência KVA não pode ser nula!")
        @Digits(integer = 10, fraction = 2)
        BigDecimal potenciaKva,

        @NotNull(message = "Limite de Temperatura do Óleo não pode ser nula!")
        @Digits(integer = 5, fraction = 2, message = "Limite de Temperatura do Óleo Inválidos!")
        BigDecimal limiteTemperaturaOleo,

        @NotNull(message = "Limite de Temperatura do Enrolamento não pode ser nula!")
        @Digits(integer = 5, fraction = 2, message = "Limite de Temperatura do Enrolamento Inválidos!")
        BigDecimal limiteTemperaturaEnrolamento
) {
}
