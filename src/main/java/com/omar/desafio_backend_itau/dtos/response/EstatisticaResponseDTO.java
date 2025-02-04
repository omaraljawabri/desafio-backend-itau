package com.omar.desafio_backend_itau.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record EstatisticaResponseDTO(
        @Schema(description = "Quantidade de transações em determinado período de tempo", example = "2", type = "long")
        Long count,
        @Schema(description = "Soma de todas as transações em determinado período de tempo", example = "1379.98", type = "double")
        Double sum,
        @Schema(description = "Média de todas as transações em determinado período de tempo", example = "678.99", type = "double")
        Double avg,
        @Schema(description = "Valor mínimo entre todas as transações em determinado período de tempo", example = "678.99", type = "double")
        Double min,
        @Schema(description = "Valor máximo entre todas as transações em determinado período de tempo", example = "700.99", type = "double")
        Double max
) {
}
