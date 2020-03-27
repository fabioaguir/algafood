package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    public List<Estado> todos();
    public Estado porId(Long id);
    public Estado adicionar(Estado estado);
    public void remover(Estado estado);
}
