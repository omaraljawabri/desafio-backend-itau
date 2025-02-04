package com.omar.desafio_backend_itau.utils;

import com.omar.desafio_backend_itau.dtos.request.TransacaoRequestDTO;

import java.time.OffsetDateTime;

public class EntityUtils {

    public static TransacaoRequestDTO criarTransacaoRequestDTO(){
        return new TransacaoRequestDTO(678.99D, OffsetDateTime.now().minusSeconds(30));
    }
}
