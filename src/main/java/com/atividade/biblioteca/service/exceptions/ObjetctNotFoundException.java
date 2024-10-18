package com.atividade.biblioteca.service.exceptions;

import org.hibernate.ObjectNotFoundException;

import java.util.Objects;

public class ObjetctNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjetctNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjetctNotFoundException(String message) {
        super(message);
    }
}
