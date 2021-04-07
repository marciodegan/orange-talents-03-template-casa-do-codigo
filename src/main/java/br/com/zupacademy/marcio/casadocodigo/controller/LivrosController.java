package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.controller.dto.LivroRequest;
import br.com.zupacademy.marcio.casadocodigo.controller.dto.LivroResponse;
import br.com.zupacademy.marcio.casadocodigo.model.Livro;
import br.com.zupacademy.marcio.casadocodigo.repository.LivroRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {

//    @Autowired
//    private EntityManager manager;

    private LivroRepository livroRepository;

    public LivrosController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public List<LivroResponse> buscarTodos() {
        return LivroResponse.converter(livroRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest livroRequest){
        return ResponseEntity.ok(new LivroResponse(livroRepository.save(livroRequest.converter())));
//        return ResponseEntity.ok(new LivroResponse(livroRepository.save(livroRequest.converter(manager)))); // utilizando o EntityManager



    /* Outras maneiras para o método listar()
    @GetMapping
    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> listar() {
        return ResponseEntity.ok(LivroResponse.converter(livroRepository.findAll()));
    }
    */

    }
}
