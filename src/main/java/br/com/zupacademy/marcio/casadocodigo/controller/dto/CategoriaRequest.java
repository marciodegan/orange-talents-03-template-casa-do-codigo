package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.model.Categoria;
import br.com.zupacademy.marcio.casadocodigo.validation.UniqueName;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

	@NotBlank @UniqueName
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
