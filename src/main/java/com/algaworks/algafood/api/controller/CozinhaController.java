package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @GetMapping()
    public List<Cozinha> todas() {
        return cozinhaRepository.findAll();
    }

//    @GetMapping("/consulta/por-nome")
//    public List<Cozinha> consultarPorNome(@RequestParam String nome) {
//        return cozinhaRepository.consultarPorNome(nome);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable() Long id) {
        Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

        if(cozinha.isPresent()) {
            return ResponseEntity.ok(cozinha.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha salvar(@RequestBody Cozinha cozinha) {
        return cadastroCozinha.salvar(cozinha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> alterar(@PathVariable() Long id,
                                           @RequestBody Cozinha cozinha) {
        Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(id);

        if(cozinhaAtual.isEmpty()) {
            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
            Cozinha cozinhaDalva = cadastroCozinha.salvar(cozinhaAtual.get());

            return ResponseEntity.ok(cozinhaDalva);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long id) {
        try {
            cadastroCozinha.excluir(id);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
