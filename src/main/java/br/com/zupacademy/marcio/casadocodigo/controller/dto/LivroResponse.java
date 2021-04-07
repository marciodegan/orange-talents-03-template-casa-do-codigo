package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.model.Autor;
import br.com.zupacademy.marcio.casadocodigo.model.Categoria;
import br.com.zupacademy.marcio.casadocodigo.model.Livro;
import br.com.zupacademy.marcio.casadocodigo.validation.MustExist;
import br.com.zupacademy.marcio.casadocodigo.validation.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class LivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private double preco;
    private int paginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private Long categoriaId;
    private Long autorId;

    public LivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoriaId = livro.getCategoria().getId();
        this.autorId = livro.getAutor().getId();
    }


    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public double getPreco() {
        return preco;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }
}