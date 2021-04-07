package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.model.Livro;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<LivroResponse> converter(List<Livro> livros) {
        return livros.stream().map(LivroResponse::new).collect(Collectors.toList());

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