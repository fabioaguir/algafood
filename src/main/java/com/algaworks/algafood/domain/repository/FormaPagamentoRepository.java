package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {

    public List<FormaPagamento> todas();
    public FormaPagamento porId(Long id);
    public FormaPagamento adicionar(FormaPagamento formaPagamento);
    public void remover(FormaPagamento formaPagamento);
}
