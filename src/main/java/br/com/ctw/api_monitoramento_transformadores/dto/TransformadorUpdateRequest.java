package br.com.ctw.api_monitoramento_transformadores.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * Exemplo de Entrada:
 * <br>
 * { <br>
 *         "limiteTemperaturaOleo": 85.00,
 *         <br>
 *         "limiteTemperaturaEnrolamento": 105.00
 *         <br>
 * }
 *
 * @param limiteTemperaturaEnrolamento Limite de Temperatura do Enrolamento
 * @param limiteTemperaturaOleo Limite de Temperatura do Óleo
 */
public record TransformadorUpdateRequest(
        @NotNull(message = "Limite de Temperatura do Enrolamento não pode ser nula!")
        @Digits(integer = 5, fraction = 2)
        BigDecimal limiteTemperaturaEnrolamento,

        @NotNull(message = "Limite de Temperatura do Óleo não pode ser nula!")
        @Digits(integer = 5, fraction = 2)
        BigDecimal limiteTemperaturaOleo
) {
}
