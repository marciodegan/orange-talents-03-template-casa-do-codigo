package br.com.zupacademy.marcio.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MustExistValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface MustExist {

    String message() default "Não encontrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> klass();
}
