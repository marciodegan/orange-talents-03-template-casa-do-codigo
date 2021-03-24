package br.com.zupacademy.marcio.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.marcio.casadocodigo.form.AutorNovoRequest;
import br.com.zupacademy.marcio.casadocodigo.model.Autor;
import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutoresController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public String novoAutor(@RequestBody @Valid AutorNovoRequest form)	{
		Autor autor = form.toModel();
		autor = autorRepository.save(autor);
		return autor.toString();
	}
}


