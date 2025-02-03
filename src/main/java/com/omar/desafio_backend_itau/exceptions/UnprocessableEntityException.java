package com.omar.desafio_backend_itau.exceptions;

public class UnprocessableEntityException extends RuntimeException {

    public UnprocessableEntityException(){
        super("Erro durante o processamento da entidade");
    }

    public UnprocessableEntityException(String message) {
        super(message);
    }
}
