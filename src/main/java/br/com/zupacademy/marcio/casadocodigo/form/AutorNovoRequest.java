package br.com.zupacademy.marcio.casadocodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.marcio.casadocodigo.model.Autor;
import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;

public class AutorNovoRequest {
	@NotBlank
	private String nome;
	@NotBlank @Email
	private String email;
	@NotBlank
	private String descricao;

	public AutorNovoRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
}