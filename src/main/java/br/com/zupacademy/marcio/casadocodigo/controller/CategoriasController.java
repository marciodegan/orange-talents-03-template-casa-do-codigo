package br.com.zupacademy.marcio.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.marcio.casadocodigo.form.CategoriaNovaRequest;
import br.com.zupacademy.marcio.casadocodigo.model.Categoria;
import br.com.zupacademy.marcio.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.marcio.casadocodigo.validation.ProibeNomeDuplicadoCategoriaValidator;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
	}
	
	@PostMapping
	public String novaCategoria(@RequestBody @Valid CategoriaNovaRequest request) throws Exception {
		Categoria categoria = request.toModel();
		categoria = categoriaRepository.save(categoria);
		return categoria.toString();
	}

}
