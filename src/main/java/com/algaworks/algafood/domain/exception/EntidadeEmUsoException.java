package com.algaworks.algafood.domain.exception;

public class EntidadeEmUsoException extends RuntimeException {
    private static final long seriaLVersionUID = 1L;

    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }
}
