package br.com.zupacademy.marcio.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.zupacademy.marcio.casadocodigo.controller.dto.AutorRequest;
import br.com.zupacademy.marcio.casadocodigo.controller.dto.AutorResponse;
import br.com.zupacademy.marcio.casadocodigo.model.Autor;
import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutoresController {

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping
	public List<Autor> listar() {
		return autorRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<AutorResponse> cadastrarAutor(@RequestBody @Valid AutorRequest autorRequest) {
		return ResponseEntity.ok(new AutorResponse(autorRepository.save(autorRequest.converter())));
	}
}

