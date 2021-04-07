package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.model.Autor;
import br.com.zupacademy.marcio.casadocodigo.model.Categoria;
import br.com.zupacademy.marcio.casadocodigo.model.Livro;
import br.com.zupacademy.marcio.casadocodigo.validation.MustExist;
import br.com.zupacademy.marcio.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank @Size(max=500)
    private String resumo;

    private String sumario;

    @NotNull @Min(20)
    private double preco;

    @NotNull @Min(100)
    private int paginas;

    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @MustExist(klass=Categoria.class)
    private Long categoriaId;

    @MustExist(klass=Autor.class)
    private Long autorId;

    public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario, @NotBlank @Min(20) double preco, int paginas, @NotBlank String isbn, @Future LocalDate dataPublicacao, Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public String getResumo() {
        return resumo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Livro converter() {
        Categoria categoria = new Categoria(categoriaId);
        Autor autor = new Autor(autorId);
        System.out.println(autor.getEmail());
        return new Livro(this.titulo, this.resumo, this.sumario,
                this.preco, this.paginas, this.isbn, this.dataPublicacao, categoria, autor);
        }
}
