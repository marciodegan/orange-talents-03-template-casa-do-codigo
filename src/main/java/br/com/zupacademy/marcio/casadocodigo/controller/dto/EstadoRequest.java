package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.model.*;
import br.com.zupacademy.marcio.casadocodigo.validation.MustExist;
import br.com.zupacademy.marcio.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class EstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @MustExist(klass= Pais.class)
    private Long paisId;

    public EstadoRequest() {
    }

    public EstadoRequest(Estado estado) {
        this.nome = estado.getNome();
        this.paisId = estado.getPais().getId();
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado converter(){
        Pais pais = new Pais(paisId);
        return new Estado(this.nome, pais);
    }
}
