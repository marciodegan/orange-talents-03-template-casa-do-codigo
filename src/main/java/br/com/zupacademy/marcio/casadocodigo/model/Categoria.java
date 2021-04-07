package br.com.zupacademy.marcio.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true, nullable = false)
	private String nome;

	@Deprecated
	public Categoria(){
	}
	// para Livro - categoriaId
	public Categoria(Long id) {
		this.id = id;
	}

	public Categoria(String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
