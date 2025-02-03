package com.omar.desafio_backend_itau.controllers;

import com.omar.desafio_backend_itau.dtos.request.TransacaoRequestDTO;
import com.omar.desafio_backend_itau.services.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> salvarTransacao(@RequestBody TransacaoRequestDTO transacaoRequestDTO){
        transacaoService.salvarTransacao(transacaoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> removerTransacoes(){
        transacaoService.removerTransacoes();
        return ResponseEntity.ok().build();
    }
}
