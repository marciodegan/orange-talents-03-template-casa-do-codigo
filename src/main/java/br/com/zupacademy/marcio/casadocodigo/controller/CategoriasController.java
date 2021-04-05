package br.com.zupacademy.marcio.casadocodigo.controller;

import javax.validation.Valid;

import br.com.zupacademy.marcio.casadocodigo.controller.dto.CategoriaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.zupacademy.marcio.casadocodigo.controller.dto.CategoriaRequest;
import br.com.zupacademy.marcio.casadocodigo.model.Categoria;
import br.com.zupacademy.marcio.casadocodigo.repository.CategoriaRepository;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<CategoriaResponse> cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest) {
		return ResponseEntity.ok(new CategoriaResponse(categoriaRepository.save(categoriaRequest.converter())));
	}

}
