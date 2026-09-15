package br.com.ctw.api_monitoramento_transformadores.mapper;

import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorDetalhadoResponse;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorRequest;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorResponse;
import br.com.ctw.api_monitoramento_transformadores.entity.LeituraTermica;
import br.com.ctw.api_monitoramento_transformadores.entity.Tecnico;
import br.com.ctw.api_monitoramento_transformadores.entity.Transformador;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper para conversão de Objetos do Transformador
 */
@Component
public class TransformadorMapper {
    /**
     * Converte uma Request DTO de Transformador em uma Entidade Transformador
     * @param request Transformador Request DTO para criação de um Transformador
     * @return Transformador
     */
    public Transformador toEntity(TransformadorRequest request) {
        return Transformador.builder()
                .numeroSerie(request.numeroSerie())
                .modelo(request.modelo())
                .subestacao(request.subestacao())
                .potenciaKva(request.potenciaKva())
                .limiteTemperaturaEnrolamento(request.limiteTemperaturaOleo())
                .limiteTemperaturaOleo(request.limiteTemperaturaOleo())
                .build();
    }

    /**
     * Converte uma Entidade Transformador para uma Response DTO detalhado (contém IDs de Leituras e Alertas)
     * @param transformador Entidade Transformador
     * @return TransformadorDetalhadoResponse
     */
    public TransformadorDetalhadoResponse toResponseDetalhado(Transformador transformador) {
        return new TransformadorDetalhadoResponse(
                transformador.getId(),
                transformador.getNumeroSerie(),
                transformador.getModelo(),
                transformador.getSubestacao(),
                transformador.getPotenciaKva(),
                transformador.getLimiteTemperaturaOleo(),
                transformador.getLimiteTemperaturaEnrolamento(),
                transformador.getLeituras().stream().map(LeituraTermica::getId).toList(),
                transformador.getTecnicos().stream().map(Tecnico::getId).toList()
        );
    }

    /**
     * Converte uma Entidade Transformador para uma Response DTO comum
     * @param transformador Entidade Transformador
     * @return TransformadorResponse
     */
    public TransformadorResponse toResponse(Transformador transformador) {
        return new TransformadorResponse(
                transformador.getId(),
                transformador.getNumeroSerie(),
                transformador.getModelo(),
                transformador.getSubestacao(),
                transformador.getPotenciaKva(),
                transformador.getLimiteTemperaturaOleo(),
                transformador.getLimiteTemperaturaEnrolamento()
        );
    }

    /**
     * Estratégia para enviar uma Lista de Transformadores e transformá-los em uma Lista de Transformadores Response
     * @param transformadores Lista de Entidade de Transformadores
     * @return Lista de TransformadorResponse
     */
    public List<TransformadorResponse> toResponseList(List<Transformador> transformadores) {
        return transformadores.stream().map(this::toResponse).toList();
    }

}
