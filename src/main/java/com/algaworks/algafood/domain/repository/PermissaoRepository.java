package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    public List<Permissao> todas();
    public Permissao porId(Long id);
    public Permissao adicionar(Permissao permissao);
    public void remover(Permissao permissao);
}
