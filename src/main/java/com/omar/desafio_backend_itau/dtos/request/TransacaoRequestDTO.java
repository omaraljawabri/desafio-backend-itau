package com.omar.desafio_backend_itau.dtos.request;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(
        Double valor,
        OffsetDateTime dataHora
) {
}
