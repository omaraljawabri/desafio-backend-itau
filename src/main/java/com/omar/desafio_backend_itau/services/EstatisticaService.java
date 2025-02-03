package com.omar.desafio_backend_itau.services;

import com.omar.desafio_backend_itau.dtos.request.TransacaoRequestDTO;
import com.omar.desafio_backend_itau.dtos.response.EstatisticaResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class EstatisticaService {

    private final TransacaoService transacaoService;

    public EstatisticaResponseDTO buscarEstatisticasDasTransacoes(Integer tempoDeBusca){
        log.info("Iniciando busca por estatísticas das transações");
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoesPorTempo(tempoDeBusca);
        if (transacoes.isEmpty()){
            log.info("Não há transações, valores retornados são todos 0");
            return new EstatisticaResponseDTO(0L, 0D, 0D, 0D, 0D);
        }
        DoubleSummaryStatistics estatisticas = transacoes.stream().collect(Collectors.summarizingDouble(TransacaoRequestDTO::valor));
        log.info("Estatísticas buscadas com sucesso!");
        return new EstatisticaResponseDTO(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax()
        );
    }

}
