
package br.com.zupacademy.marcio.casadocodigo.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.marcio.casadocodigo.form.CategoriaNovaRequest;
import br.com.zupacademy.marcio.casadocodigo.model.Categoria;
import br.com.zupacademy.marcio.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaNovaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		CategoriaNovaRequest request = (CategoriaNovaRequest) target;
		Optional<Categoria> possivelAutor = categoriaRepository.findByNome(request.getNome());

		if (possivelAutor.isPresent()) {
			errors.rejectValue("nome", null,
					"Já existe uma categoria com este nome: " + request.getNome());
		}

	}

}
