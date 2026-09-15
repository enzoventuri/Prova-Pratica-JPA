package br.com.ctw.api_monitoramento_transformadores.dto;

import org.springframework.http.HttpStatus;

/**
 * Exemplo de Saída:
 * <br>
 * { <br>
 *     "message": "Transformador não encontrado com Número Série: TRF-",
 *     <br>
 *     "status": "404 NOT_FOUND",
 *     <br>
 *     "time": "2026-09-14T19:19:01.365255100"
 *     <br>
 * }
 * @param message Mensagem de Erro da exceção
 * @param status Status de Erro (ex: 404)
 * @param time Tempo exato de quando ocorreu o erro
 */
public record ErrorResponse(
    String message,
    HttpStatus status,
    String time
) {
}
