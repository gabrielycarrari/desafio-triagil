package com.gabriely.desafiotriagil.exception;

public class NegocioException extends RuntimeException {

    public NegocioException() {
        this("Ocorreu um erro de negócio!");
    }

    public NegocioException(String message) {
        this(message, null);
    }

    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

}
