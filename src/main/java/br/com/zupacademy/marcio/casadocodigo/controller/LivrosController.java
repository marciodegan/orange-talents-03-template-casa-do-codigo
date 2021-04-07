package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.controller.dto.DetalheSiteLivroResponse;
import br.com.zupacademy.marcio.casadocodigo.controller.dto.LivroRequest;
import br.com.zupacademy.marcio.casadocodigo.controller.dto.LivroResponse;
import br.com.zupacademy.marcio.casadocodigo.model.Livro;
import br.com.zupacademy.marcio.casadocodigo.repository.LivroRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @PersistenceContext
    private EntityManager manager;

    private LivroRepository livroRepository;

    public LivrosController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public List<LivroResponse> listar() {
        return LivroResponse.converter(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Livro livroBuscado = manager.find(Livro.class, id);
        if (livroBuscado == null) {
            return ResponseEntity.notFound().build();
        }
        DetalheSiteLivroResponse detalheSiteLivroResponse = new DetalheSiteLivroResponse(
                livroBuscado);
        return ResponseEntity.ok(detalheSiteLivroResponse);
    }

    @PostMapping
    public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest livroRequest) {
        return ResponseEntity.ok(new LivroResponse(livroRepository.save(livroRequest.converter())));
//        return ResponseEntity.ok(new LivroResponse(livroRepository.save(livroRequest.converter(manager)))); // utilizando o EntityManager
    }
}

