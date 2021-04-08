package br.com.zupacademy.marcio.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(unique = true, nullable = false)
    private String nome;

    @ManyToOne @NotNull
    private Pais pais;

    @Deprecated
    public Estado(){

    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return this.nome;
    }

    public Pais getPais() {
        return this.pais;
    }
}
