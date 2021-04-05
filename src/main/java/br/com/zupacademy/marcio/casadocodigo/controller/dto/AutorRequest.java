package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.marcio.casadocodigo.model.Autor;
import br.com.zupacademy.marcio.casadocodigo.validation.Unique;
import br.com.zupacademy.marcio.casadocodigo.validation.UniqueEmail;

import java.util.Locale;


public class AutorRequest {
	@NotBlank
	private String nome;
	@NotBlank @Email @Unique
	private String email;
	@NotBlank @Size(max=400)
	private String descricao;

	public AutorRequest(@NotBlank String nome, @NotBlank @Email String email, String descricao) {
		this.nome = nome;
		this.email = email.toLowerCase();
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor converter() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
	
	
}