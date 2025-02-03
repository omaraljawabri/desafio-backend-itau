package com.omar.desafio_backend_itau.services;

import com.omar.desafio_backend_itau.dtos.request.TransacaoRequestDTO;
import com.omar.desafio_backend_itau.exceptions.UnprocessableEntityException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class TransacaoService {

    private final List<TransacaoRequestDTO> transacoes = new ArrayList<>();

    public void salvarTransacao(TransacaoRequestDTO transacaoRequestDTO){
        log.info("Iniciando processo de salvamento da transação");

        if (transacaoRequestDTO.dataHora() == null || transacaoRequestDTO.valor() == null){
            log.error("UnprocessableEntityException: dataHora e valor não podem ser nulos");
            throw new UnprocessableEntityException("atributos dataHora e valor não podem ser nulos");
        }

        if (transacaoRequestDTO.dataHora().isAfter(OffsetDateTime.now())){
            log.error("UnprocessableEntityException: data e hora do atributo dataHora devem ser anteriores a data e hora atuais");
            throw new UnprocessableEntityException("data e hora do atributo dataHora devem ser anteriores a data e hora atuais");
        }

        if (transacaoRequestDTO.valor() < 0){
            log.error("UnprocessableEntityException: valor deve ser maior ou igual a 0");
            throw new UnprocessableEntityException("valor deve ser maior ou igual a 0");
        }

        transacoes.add(transacaoRequestDTO);
        log.info("Transação salva com sucesso!");
    }

    public void removerTransacoes(){
        log.info("Iniciando processo de remoção das transações");
        int qtdTransacoes = transacoes.size();
        transacoes.clear();
        log.info("Todas as transações foram removidas com sucesso. Total de transações removidas: {}", qtdTransacoes);
    }
}
