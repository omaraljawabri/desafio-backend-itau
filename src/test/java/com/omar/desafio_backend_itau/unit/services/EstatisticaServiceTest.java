package com.omar.desafio_backend_itau.unit.services;

import com.omar.desafio_backend_itau.dtos.response.EstatisticaResponseDTO;
import com.omar.desafio_backend_itau.services.EstatisticaService;
import com.omar.desafio_backend_itau.services.TransacaoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static com.omar.desafio_backend_itau.utils.EntityUtils.criarTransacaoRequestDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.when;

@ExtendWith(SpringExtension.class)
class EstatisticaServiceTest {

    @InjectMocks
    private EstatisticaService estatisticaService;

    @Mock
    private TransacaoService transacaoService;

    @Test
    @DisplayName("buscarEstatisticasDasTransacoes deve retornar um EstatisticaResponseDTO quando a busca for bem sucedida")
    void buscarEstatisticasDasTransacoes_RetornaEstatisticaResponseDTO_QuandoBemSucedido() {
        when(transacaoService.buscarTransacoesPorTempo(ArgumentMatchers.anyInt()))
                .thenReturn(List.of(criarTransacaoRequestDTO(), criarTransacaoRequestDTO()));
        EstatisticaResponseDTO estatisticaResponseDTO
                = estatisticaService.buscarEstatisticasDasTransacoes(60);
        assertThat(estatisticaResponseDTO).isNotNull();
        assertThat(estatisticaResponseDTO.count()).isEqualTo(2);
        assertThat(estatisticaResponseDTO.avg()).isEqualTo(678.99D);
        assertThat(estatisticaResponseDTO.max()).isEqualTo(678.99D);
        assertThat(estatisticaResponseDTO.min()).isEqualTo(678.99D);
        assertThat(estatisticaResponseDTO.sum()).isEqualTo(1357.98D);
    }

    @Test
    @DisplayName("buscarEstatisticasDasTransacoes deve retornar um EstatisticaResponseDTO com os valores zerados quando não houverem transações retornadas pelo TransacaoService")
    void buscarEstatisticasDasTransacoes_RetornaEstatisticaResponseDTOComValoresZerados_QuandoNaoHaDadosVindosDaClasseTransacaoService(){
        when(transacaoService.buscarTransacoesPorTempo(ArgumentMatchers.anyInt()))
                .thenReturn(Collections.emptyList());
        EstatisticaResponseDTO estatisticaResponseDTO
                = estatisticaService.buscarEstatisticasDasTransacoes(10);
        assertThat(estatisticaResponseDTO).isNotNull();
        assertThat(estatisticaResponseDTO.count()).isZero();
        assertThat(estatisticaResponseDTO.avg()).isEqualTo(0D);
        assertThat(estatisticaResponseDTO.max()).isEqualTo(0D);
        assertThat(estatisticaResponseDTO.min()).isEqualTo(0D);
        assertThat(estatisticaResponseDTO.sum()).isEqualTo(0D);
    }
}