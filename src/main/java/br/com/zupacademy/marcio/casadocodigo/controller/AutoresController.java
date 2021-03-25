package br.com.zupacademy.marcio.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.marcio.casadocodigo.form.AutorNovoRequest;
import br.com.zupacademy.marcio.casadocodigo.model.Autor;
import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.marcio.casadocodigo.validation.ProibeEmailDuplicadoAutorValidator;

@RestController
@RequestMapping("/autores")
public class AutoresController {

	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}
	
	@PostMapping
	public String novoAutor(@RequestBody @Valid AutorNovoRequest form) throws Exception {
//		Autor autorExisteEmail = autorRepository.findByEmail(form.getEmail());
//		if (autorExisteEmail != null) {
//			throw new InvalidFieldException("Já existe este e-mail cadastrado");
//		} else {
		Autor autor = form.toModel();
		autor = autorRepository.save(autor);
		return autor.toString();
		}
	}
