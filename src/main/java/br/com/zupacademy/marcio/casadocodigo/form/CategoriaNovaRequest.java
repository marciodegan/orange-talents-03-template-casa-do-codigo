package br.com.zupacademy.marcio.casadocodigo.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.marcio.casadocodigo.model.Categoria;

public class CategoriaNovaRequest {

	@NotBlank
	private String nome;

	@Deprecated
	public CategoriaNovaRequest() {
	}

	public CategoriaNovaRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return this.nome;
	}
	
}
