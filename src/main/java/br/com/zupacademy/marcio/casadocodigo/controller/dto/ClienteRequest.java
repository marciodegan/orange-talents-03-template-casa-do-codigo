package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.model.*;
import br.com.zupacademy.marcio.casadocodigo.validation.Documento;
import br.com.zupacademy.marcio.casadocodigo.validation.MustExist;
import br.com.zupacademy.marcio.casadocodigo.validation.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteRequest {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @Documento
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;

    @NotNull
    @MustExist(klass = Pais.class)
    private Long paisId;

    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Documento String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long paisId, Long estadoId, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }


    public Cliente toModel(EntityManager manager) {
        @NotNull
        Pais pais = manager.find(Pais.class, paisId);

        Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco,
                complemento, cidade, pais, telefone, cep);

        if (estadoId != null) {
            cliente.setEstado(manager.find(Estado.class, estadoId));
        }
        return cliente;
    }

    public boolean temEstado() {
        return Optional.ofNullable(estadoId).isPresent();
    }

}