package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    public List<Restaurante> todos();
    public Restaurante porId(Long id);
    public Restaurante adicionar(Restaurante restaurante);
    public void remover(Restaurante restaurante);
}
