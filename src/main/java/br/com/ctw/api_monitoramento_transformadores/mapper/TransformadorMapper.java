package br.com.ctw.api_monitoramento_transformadores.mapper;

import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorDetalhadoResponseDTO;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorRequest;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorResponse;
import br.com.ctw.api_monitoramento_transformadores.entity.Transformador;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransformadorMapper {
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

//    public TransformadorDetalhadoResponseDTO toResponseDetalhado(Transformador transformador) {
//        return new TransformadorDetalhadoResponseDTO(
//                transformador.getId(),
//                transformador.getNumeroSerie(),
//                transformador.getModelo(),
//                transformador.getSubestacao(),
//                transformador.getPotenciaKva(),
//                transformador.getLimiteTemperaturaOleo(),
//                transformador.getLimiteTemperaturaEnrolamento(),
//                transformador.getLeituras(),
//                transformador.getAlertas()
//        );
//    }

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

    public List<TransformadorResponse> toResponseList(List<Transformador> transformadores) {
        return transformadores.stream().map(this::toResponse).toList();
    }

}
