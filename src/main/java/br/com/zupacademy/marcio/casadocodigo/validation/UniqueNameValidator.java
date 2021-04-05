package br.com.zupacademy.marcio.casadocodigo.validation;

import br.com.zupacademy.marcio.casadocodigo.repository.CategoriaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private CategoriaRepository categoriaRepository;

    public UniqueNameValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    @Override
    public void initialize(UniqueName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext context) {
        return !categoriaRepository.findByNome(nome).isPresent();
    }
}
