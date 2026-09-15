package br.com.ctw.api_monitoramento_transformadores.dto;

import java.math.BigDecimal;

/**
 * Exemplo de Saída:
 * <br>
 * { <br>
 *         "id": 1,
 *         <br>
 *         "numeroSerie": "TRF-2026-1001",
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
 *}
 *
 * @param id ID do Transformador
 * @param numeroSerie Número de Série do Transformador
 * @param modelo Modelo do Transformador
 * @param subestacao Subestação do Transformador
 * @param potenciaKva Potência em KVA do Transformador
 * @param limiteTemperaturaOleo Limite de Temperatura do Óleo do Transformador
 * @param limiteTemperaturaEnrolamento Limite de Temperatura do Enrolamento do Transformador
 */
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
