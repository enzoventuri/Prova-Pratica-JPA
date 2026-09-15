package br.com.ctw.api_monitoramento_transformadores.service;

import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorDetalhadoResponse;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorRequest;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorResponse;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorUpdateRequest;
import br.com.ctw.api_monitoramento_transformadores.entity.Transformador;
import br.com.ctw.api_monitoramento_transformadores.exception.NotFoundException;
import br.com.ctw.api_monitoramento_transformadores.exception.RegraDeNegocioException;
import br.com.ctw.api_monitoramento_transformadores.mapper.TransformadorMapper;
import br.com.ctw.api_monitoramento_transformadores.repository.TransformadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service para Regras de Negócios do Transformador
 */
@Service
@RequiredArgsConstructor
public class TransformadorService {
    private final TransformadorMapper mapper;
    private final TransformadorRepository repository;

    /**
     * Cadastra Transformador
     * @param request Request DTO de Transformador
     * @return TransformadorResponse
     */
    @Transactional
    public TransformadorResponse cadastrarTransformador(TransformadorRequest request) {
        Transformador transformador = mapper.toEntity(request);

        try {
            Transformador salvo = repository.save(transformador);

            return mapper.toResponse(salvo);
        } catch (RuntimeException e) {
            throw new RegraDeNegocioException("Já possui um Transformador com o mesmo Númerio de Serie!");
        }

    }

    /**
     * Valida se não tem Transformador na Lista e exibe todos Transformadores
     * @throws NotFoundException Exceção lançada somente quando não houver nenhum Transformador
     * @return Lista de TransformadorResponse
     */
    @Transactional(readOnly = true)
    public List<TransformadorResponse> getTransformadores() {
        List<Transformador> transformadores = repository.findAll();

        if (transformadores.isEmpty()) {
            throw new NotFoundException("Não existem transformadores!");
        }

        return mapper.toResponseList(transformadores);
    }

    /**
     * Valida se existe um Transformador com o Número de Série recebido e exibe
     * @param numeroSerie Númerio de Série do Transformador
     * @throws NotFoundException Exceção lançada somente quando não achar um Transformador com o Númerio de Série recebida
     * @return TransformadorDetalhadoResponse
     */
    @Transactional(readOnly = true)
    public TransformadorDetalhadoResponse getDetalhadoTransformador(String numeroSerie) {
        Transformador transformador = repository.findByNumeroSerie(numeroSerie);

        if (transformador == null) {
            throw new NotFoundException("Transformador não encontrado com Número Série: " + numeroSerie);
        }

        return mapper.toResponseDetalhado(transformador);
    }

    /**
     * Valida se existe um Transformador com o Número de Série recebido e atualiza Transformador
     * @param numeroSerie Número de Série do Transformador
     * @param request Request DTO do Transformador
     * @throws NotFoundException Exceção lançada somente quando não achar um Transformador com o Númerio de Série recebida
     * @return TransformadorResponse
     */
    @Transactional
    public TransformadorResponse atualizaTransformador(String numeroSerie, TransformadorUpdateRequest request) {
        Transformador transformador = repository.findByNumeroSerie(numeroSerie);

        if (transformador == null) {
            throw new NotFoundException("Transformador não encontrado com Número Série: " + numeroSerie);
        }

        transformador.setLimiteTemperaturaEnrolamento(request.limiteTemperaturaEnrolamento());
        transformador.setLimiteTemperaturaOleo(request.limiteTemperaturaOleo());

        return mapper.toResponse(repository.save(transformador));
    }

    /**
     * Valida se existe um Transformador com o Número de Série recebido e deleta o Transformador
     * @param numeroSerie Númerio de Série do Transformador
     * @throws NotFoundException Exceção lançada somente quando não achar um Transformador com o Númerio de Série recebida
     */
    @Transactional
    public void deleteTransformador(String numeroSerie) {
        if (repository.findByNumeroSerie(numeroSerie) == null) {
            throw new NotFoundException("Transformador não encontrado com Número Série: " + numeroSerie);
        }

        repository.removeByNumeroSerie(numeroSerie);
    }

}
