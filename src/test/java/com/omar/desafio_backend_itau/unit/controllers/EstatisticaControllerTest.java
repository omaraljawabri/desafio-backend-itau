package com.omar.desafio_backend_itau.unit.controllers;

import com.omar.desafio_backend_itau.controllers.EstatisticaController;
import com.omar.desafio_backend_itau.dtos.response.EstatisticaResponseDTO;
import com.omar.desafio_backend_itau.services.EstatisticaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.omar.desafio_backend_itau.utils.EntityUtils.criarEstatisticaResponseDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.when;

@ExtendWith(SpringExtension.class)
class EstatisticaControllerTest {

    @InjectMocks
    private EstatisticaController estatisticaController;

    @Mock
    private EstatisticaService estatisticaService;

    @Test
    @DisplayName("buscarEstatisticasDasTransacoes deve retornar EstatisticaResponseDTO e um http status 200 quando bem sucedido")
    void buscarEstatisticasDasTransacoes_RetornaEstatisticaResponseDTOEStatus200_QuandoBemSucedido() {
        when(estatisticaService.buscarEstatisticasDasTransacoes(ArgumentMatchers.anyInt()))
                .thenReturn(criarEstatisticaResponseDTO());
        ResponseEntity<EstatisticaResponseDTO> responseEntity = estatisticaController.buscarEstatisticasDasTransacoes(60);
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().count()).isEqualTo(2L);
    }
}