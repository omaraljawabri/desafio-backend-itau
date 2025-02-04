package com.omar.desafio_backend_itau.controllers;

import com.omar.desafio_backend_itau.dtos.request.TransacaoRequestDTO;
import com.omar.desafio_backend_itau.services.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
@Tag(description = "Endpoints responsáveis por salvar e remover transações", name= "TransacaoController")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @Operation(summary = "Endpoint responsável por salvar uma transação (adicionar ao ArrayList)",
            method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação realizada com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Bad request (Aplicação não compreendeu a requisição do usuário)"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity (Erro de validação dos atributos)"),
            @ApiResponse(responseCode = "500", description = "Internal Server Erro (Erro interno ao realizar operação)")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> salvarTransacao(@RequestBody TransacaoRequestDTO transacaoRequestDTO){
        transacaoService.salvarTransacao(transacaoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Endpoint responsável por remover todas as transações salvas até então no ArrayList",
            method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Bad request (Aplicação não compreendeu a requisição do usuário)"),
            @ApiResponse(responseCode = "500", description = "Internal Server Erro (Erro interno ao realizar operação)")
    })
    @DeleteMapping
    public ResponseEntity<Void> removerTransacoes(){
        transacaoService.removerTransacoes();
        return ResponseEntity.ok().build();
    }
}
