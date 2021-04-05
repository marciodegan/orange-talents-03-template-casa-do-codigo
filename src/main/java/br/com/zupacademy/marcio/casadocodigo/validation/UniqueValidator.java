package br.com.zupacademy.marcio.casadocodigo.validation;

import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.marcio.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public void initialize(Unique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return categoriaRepository.encontraDuplicadoNome(value).isEmpty()
                && autorRepository.encontraDuplicadoEmail(value).isEmpty();
    }
}
