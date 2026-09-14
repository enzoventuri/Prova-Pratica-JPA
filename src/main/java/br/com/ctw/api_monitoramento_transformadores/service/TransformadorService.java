package br.com.ctw.api_monitoramento_transformadores.service;

import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorDetalhadoResponseDTO;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorRequest;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorResponse;
import br.com.ctw.api_monitoramento_transformadores.entity.Transformador;
import br.com.ctw.api_monitoramento_transformadores.mapper.TransformadorMapper;
import br.com.ctw.api_monitoramento_transformadores.repository.TransformadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransformadorService {
    private final TransformadorMapper mapper;
    private final TransformadorRepository repository;

    public TransformadorResponse cadastrarTransformador(TransformadorRequest request) {
        Transformador transformador = mapper.toEntity(request);

        Transformador salvo = repository.save(transformador);

        return mapper.toResponse(salvo);
    }

    public List<TransformadorResponse> getTransformadores() {
        return mapper.toResponseList(repository.findAll());
    }

//    public TransformadorDetalhadoResponseDTO getDetalhadoTransformador(String numeroSerie) {
//        return mapper.toResponseDetalhado(repository.findByNumeroSerie(numeroSerie));
//    }

    public TransformadorResponse atualizaTransformador(TransformadorRequest request) {
        Transformador transformador = mapper.toEntity(request);

        return mapper.toResponse(repository.save(transformador));
    }

    public void deleteTransformador(String numeroSerie) {
        repository.deleteByNumeroSerie(numeroSerie);
    }

}
