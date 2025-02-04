package com.omar.desafio_backend_itau.controllers;

import com.omar.desafio_backend_itau.dtos.response.EstatisticaResponseDTO;
import com.omar.desafio_backend_itau.services.EstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estatistica")
@Tag(description = "Endpoints relacionados com estatísticas das transações", name = "EstatisticaController")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    @Operation(summary = "Endpoint responsável por buscar estatísticas das transações em um determinado período de tempo",
            description = "Busca estatísticas nos últimos 60 segundos como padrão ou no tempo passado como parâmetro",
            method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Bad request (Aplicação não compreendeu a requisição do usuário)"),
            @ApiResponse(responseCode = "500", description = "Internal Server Erro (Erro interno ao realizar operação)")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstatisticaResponseDTO> buscarEstatisticasDasTransacoes(
            @RequestParam(required = false, defaultValue = "60") Integer tempo
            ){
        return ResponseEntity.ok(estatisticaService.buscarEstatisticasDasTransacoes(tempo));
    }

}
