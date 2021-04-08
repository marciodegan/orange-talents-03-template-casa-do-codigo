package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.model.Pais;
import br.com.zupacademy.marcio.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public PaisRequest() {

    }

    public PaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public Pais converter() {
        return new Pais(this.nome);
    }

}
