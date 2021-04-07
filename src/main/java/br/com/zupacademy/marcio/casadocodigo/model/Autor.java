package br.com.zupacademy.marcio.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Autor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;
	
	@Column(unique=true, nullable = false)
	private String email;

	@Column(length=400)
	private String descricao;
	
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Deprecated
	public Autor(){
	}

	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor(Long id) {
		this.id = id;
	}

	// para Livro - autorId
	public Long getId() {
		return id;
	}

	public String getNome() { return nome; }

	public String getEmail() { return email; }

	public String getDescricao() { return descricao; }

	public LocalDateTime getDataCriacao() { return dataCriacao; }
	
	
}



