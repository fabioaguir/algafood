package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.model.CozinhaXmlWrapper;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping()
    public List<Cozinha> todas() {
        return cozinhaRepository.todas();
    }

    @GetMapping(value = "cozinhasXml", produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhaXmlWrapper todasXml() {
        return new CozinhaXmlWrapper(cozinhaRepository.todas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable() Long id) {
        Cozinha cozinha = cozinhaRepository.porId(id);
        return ResponseEntity.ok(cozinha);
    }
}
