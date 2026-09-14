package br.com.ctw.api_monitoramento_transformadores.dto;

import br.com.ctw.api_monitoramento_transformadores.entity.AlertaTermico;
import br.com.ctw.api_monitoramento_transformadores.entity.LeituraTermica;

import java.math.BigDecimal;
import java.util.Set;

public record TransformadorDetalhadoResponseDTO(
        Long id,
        String numeroSerie,
        String modelo,
        String subestacao,
        BigDecimal potenciaKva,
        BigDecimal limiteTemperaturaOleo,
        BigDecimal limiteTemperaturaEnrolamento,
        Set<LeituraTermica> leituras,
        Set<AlertaTermico> alertas
) {
}
