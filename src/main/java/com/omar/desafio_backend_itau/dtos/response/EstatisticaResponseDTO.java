package com.omar.desafio_backend_itau.dtos.response;

public record EstatisticaResponseDTO(
        Long count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {
}
