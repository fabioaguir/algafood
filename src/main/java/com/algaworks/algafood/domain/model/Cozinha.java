package com.algaworks.algafood.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tab_cozinhas")
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_cozinha", length = 30)
    private String nome;

    public Cozinha() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cozinha cozinha = (Cozinha) o;
        return id.equals(cozinha.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
