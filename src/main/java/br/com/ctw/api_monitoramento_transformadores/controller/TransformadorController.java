package br.com.ctw.api_monitoramento_transformadores.controller;

import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorDetalhadoResponse;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorRequest;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorResponse;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorUpdateRequest;
import br.com.ctw.api_monitoramento_transformadores.service.TransformadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Controller para Transformadores
 */
@RestController
@RequestMapping("/api/v1/transformadores")
@RequiredArgsConstructor
@Tag(name = "Transformador Controller", description = "Gerencia Endpoints para o Transformador")
public class TransformadorController {
    private final TransformadorService service;

    /**
     * Pega todos Transformadores
     * @return ResponseEntity Lista de TransformadorResponse
     */
    @Operation(
            summary = "Exibição de todos Transformadores",
            description = "Procura por todos Transformadores, se não achar lança exceção NotFoundException"
    )
    @ApiResponse(
            description = "Todos Transformadores pegos com sucesso",
            responseCode = "200"
    )
    @GetMapping
    public ResponseEntity<List<TransformadorResponse>> getTransformadores() {
        return ResponseEntity.ok(service.getTransformadores());
    }

    /**
     * Cadastra um Transformador com uma Request DTO de Transformador
     * @param request Request DTO de Transformador
     * @return ResponseEntity TransformadorResponse
     */
    @Operation(
            summary = "Cadastro de um Transformador",
            description = "Cadastra um Transformador com um Request DTO"
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Criação de um Transformador com sucesso",
                    responseCode = "201"
            ),
            @ApiResponse(
                    description = "Erro ao cadastrar Transformador",
                    responseCode = "400"
            )
    })
    @PostMapping
    public ResponseEntity<TransformadorResponse> cadastrarTransformador(@RequestBody @Valid TransformadorRequest request) {
        TransformadorResponse transformador = service.cadastrarTransformador(request);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(transformador.id())
                .toUri();

        return ResponseEntity.created(uri).body(transformador);
    }

    /**
     * Exibe um Transformador mais detalhado (adiciona Técnicos e Leitura Térmicas) com base em seu Número de Série
     * @param numeroSerie Númerio de Série do Transformador
     * @return ResponseEntity TransformadorResponse
     */
    @Operation(
            summary = "Exibição de um Transformador com detalhes",
            description = "Procura por um Transformador com base em seu Número de Série, mas também exibe Técnicos e Leituras Térmicas, se não achar Transformador lança NotFounException"
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Busca do Transformador bem sucedido",
                    responseCode = "200"
            ),
            @ApiResponse(
                    description = "Erro ao procurar o Transformador",
                    responseCode = "404"
            )
    })
    @GetMapping("{numeroSerie}")
    public ResponseEntity<TransformadorDetalhadoResponse> getTransformadorDetalhado(@PathVariable String numeroSerie) {
        return ResponseEntity.ok(service.getDetalhadoTransformador(numeroSerie));
    }

    /**
     * Atualiza um Transformador com base em seu Número de Série
     * @param numeroSerie Número de Série do Transformador
     * @param request Update Request DTO do Transformador
     * @return ResponseEntity TransformadorResponse
     */
    @Operation(
            summary = "Atualiza Transformador",
            description = "Procura por um Transformador com base em seu Número de Série e o atualiza, se não achar lança uma NotFoundException"
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Atualização do Transformador bem sucedido",
                    responseCode = "200"
            ),
            @ApiResponse(
                    description = "Erro ao procurar o Transformador",
                    responseCode = "404"
            )
    })
    @PutMapping("{numeroSerie}")
    public ResponseEntity<TransformadorResponse> atualizarTransformador(@PathVariable String numeroSerie, @Valid @RequestBody TransformadorUpdateRequest request){
        return ResponseEntity.ok(service.atualizaTransformador(numeroSerie, request));
    }

    /**
     * Deleta um Transformador com base em seu Número de Série
     * @param numeroSerie Númerio de Série do Transformador
     * @return ResponseEntity Void
     */
    @Operation(
            summary = "Deleta Transformador",
            description = "Deleta Transformador com base em seu Número de Série, se não achar é lançado uma NotFoundException"
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Transformador deletado com sucesso",
                    responseCode = "204"
            ),
            @ApiResponse(
                    description = "Erro ao procurar o Transformador",
                    responseCode = "404"
            )
    })
    @DeleteMapping("{numeroSerie}")
    public ResponseEntity<Void> deletarTransformador(@PathVariable String numeroSerie) {
        service.deleteTransformador(numeroSerie);

        return ResponseEntity.noContent().build();
    }
}
