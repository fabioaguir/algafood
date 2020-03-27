package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;

import java.util.List;

public interface CidadeRepository {

    public List<Cidade> todas();
    public Cidade porId(Long id);
    public Cidade adicionar(Cidade cidade);
    public void remover(Cidade cidade);
}
