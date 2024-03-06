package com.gabriely.desafiotriagil.exception;

public class RecordNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long id) {
        super("Registro " + id + " não encontrado.");
    }
}