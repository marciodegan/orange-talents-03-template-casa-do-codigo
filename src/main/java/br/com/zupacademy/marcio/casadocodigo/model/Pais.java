package br.com.zupacademy.marcio.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;

    @Deprecated
    public Pais() {
    }

    public Pais(@NotNull Long id) {
        this.id = id;
    }

    public Pais(@NotNull String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
