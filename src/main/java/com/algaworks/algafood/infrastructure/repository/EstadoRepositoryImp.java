package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class EstadoRepositoryImp implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> todos() {
        return manager.createQuery("FROM Estado", Estado.class)
                .getResultList();
    }

    @Override
    public Estado porId(Long id) {
        return manager.find(Estado.class, id);
    }

    @Transactional
    @Override
    public Estado adicionar(Estado estado) {
        return manager.merge(estado);
    }

    @Transactional
    @Override
    public void remover(Estado estado) {
        estado = this.porId(estado.getId());
        manager.remove(estado);
    }
}
