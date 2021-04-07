package br.com.zupacademy.marcio.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String resumo;

    private String sumario;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private int paginas;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @ManyToOne // pode ter mais de um livro para a mesma categoria
    private Categoria categoria;

    @ManyToOne // pode ter mais de um livro para o mesmo autor
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(String titulo, String resumo, String sumario, double preco, int paginas, String isbn, @Future LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return this.autor;
    }
}
