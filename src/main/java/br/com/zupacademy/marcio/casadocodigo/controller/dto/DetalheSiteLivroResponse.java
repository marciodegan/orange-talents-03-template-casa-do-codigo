package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.model.Livro;

import java.time.format.DateTimeFormatter;

public class DetalheSiteLivroResponse {

    private String titulo;
    private String isbn;
    private int numeroPaginas;
    private double preco;
    private String resumo;
    private String sumario;
    private String dataPublicacao;
    private DetalheSiteAutorResponse autor;
    private DetalheSiteCategoriaResponse categoria; // adicionei categoria como parte do estudo.

    public DetalheSiteLivroResponse(Livro livro) {
        titulo = livro.getTitulo();
        autor = new DetalheSiteAutorResponse(livro.getAutor());
        categoria = new DetalheSiteCategoriaResponse(livro.getCategoria());
        isbn = livro.getIsbn();
        numeroPaginas = livro.getPaginas();
        preco = livro.getPreco();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        dataPublicacao = livro.getDataPublicacao()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }

    public DetalheSiteCategoriaResponse getCategoria() {
        return categoria;
    }

    public DetalheSiteAutorResponse getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public double getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }
}
