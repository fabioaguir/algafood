package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CadastroRestauranteService {

    private static final String MSG_RESTAURANTE_NAO_ENCONTRADO
            = "Não existe um cadastro de restaurante com código %d";

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cadastroCozinha.buscar(cozinhaId);

        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }

    public Restaurante buscar(Long id) {
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new RestauranteNaoEncontradoException(
                        String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, id)));
    }
}
