package com.omar.desafio_backend_itau.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(
        @Schema(description = "Valor da transação em dinheiro", example = "678.99", type = "double", requiredMode = Schema.RequiredMode.REQUIRED)
        Double valor,
        @Schema(description = "Data e hora da transação", example = "2025-02-03T12:34:56.789-03:00", type = "OffsetDateTime", requiredMode = Schema.RequiredMode.REQUIRED)
        OffsetDateTime dataHora
) {
}
