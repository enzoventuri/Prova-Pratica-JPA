package br.com.ctw.api_monitoramento_transformadores.controller;

import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorDetalhadoResponseDTO;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorRequest;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorResponse;
import br.com.ctw.api_monitoramento_transformadores.service.TransformadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transformadores")
@RequiredArgsConstructor
public class TransformadorController {
    private final TransformadorService service;

    @GetMapping
    public ResponseEntity<List<TransformadorResponse>> getTransformadores() {
        return ResponseEntity.ok(service.getTransformadores());
    }

//    @PostMapping
//    public ResponseEntity<TransformadorResponse> cadastrarTransformador(@RequestBody TransformadorRequest request) {
//        return ResponseEntity.created().body(service.cadastrarTransformador(request));
//    }

//    @GetMapping("{numeroSerie}")
//    public ResponseEntity<TransformadorDetalhadoResponseDTO> getTransformadorDetalhado(@PathVariable String numeroSerie) {
//        return ResponseEntity.ok(service.getDetalhadoTransformador(numeroSerie));
//    }

//    @PutMapping("{numeroSerie}")
//    public ResponseEntity<TransformadorResponse> atualizarTransformador(@PathVariable String numeroSerie){
//        return ResponseEntity.ok(service.atualizaTransformador());
//    }

    @DeleteMapping("{numeroSerie}")
    public ResponseEntity<Void> deletarTransformador(@PathVariable String numeroSerie) {
        service.deleteTransformador(numeroSerie);

        return ResponseEntity.noContent().build();
    }
}
