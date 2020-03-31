package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.model.CozinhaXmlWrapper;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping()
    public List<Cozinha> todas() {
        return cozinhaRepository.listar();
    }

    @GetMapping(value = "cozinhasXml", produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhaXmlWrapper todasXml() {
        return new CozinhaXmlWrapper(cozinhaRepository.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable() Long id) {
        Cozinha cozinha = cozinhaRepository.buscar(id);

        if(cozinha != null) {
            return ResponseEntity.ok(cozinha);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha salvar(@RequestBody Cozinha cozinha) {
        return cozinhaRepository.salvar(cozinha);
    }
}
