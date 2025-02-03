package com.omar.desafio_backend_itau.controllers;

import com.omar.desafio_backend_itau.dtos.response.EstatisticaResponseDTO;
import com.omar.desafio_backend_itau.services.EstatisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    @GetMapping
    public ResponseEntity<EstatisticaResponseDTO> buscarEstatisticasDasTransacoes(
            @RequestParam(required = false, defaultValue = "60") Integer tempo
            ){
        return ResponseEntity.ok(estatisticaService.buscarEstatisticasDasTransacoes(tempo));
    }

}
