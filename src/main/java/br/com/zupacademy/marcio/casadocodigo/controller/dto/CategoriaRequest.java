package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.model.Autor;
import br.com.zupacademy.marcio.casadocodigo.model.Categoria;
import br.com.zupacademy.marcio.casadocodigo.validation.Unique;
import br.com.zupacademy.marcio.casadocodigo.validation.UniqueName;
import br.com.zupacademy.marcio.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

	@NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public CategoriaRequest() {
	}

	public String getNome() {
		return this.nome;
	}

	public Categoria converter() {
		return new Categoria(this.nome);
	}
}
