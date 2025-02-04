package com.omar.desafio_backend_itau.utils;

import com.omar.desafio_backend_itau.dtos.request.TransacaoRequestDTO;
import com.omar.desafio_backend_itau.dtos.response.EstatisticaResponseDTO;

import java.time.OffsetDateTime;

public class EntityUtils {

    public static TransacaoRequestDTO criarTransacaoRequestDTO(){
        return new TransacaoRequestDTO(678.99D, OffsetDateTime.now().minusSeconds(30));
    }

    public static EstatisticaResponseDTO criarEstatisticaResponseDTO(){
        return new EstatisticaResponseDTO(2L, 1357.98D, 678.99D, 678.99D, 678.99D);
    }
}
