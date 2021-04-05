package br.com.zupacademy.marcio.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface UniqueEmail {

        String message() default "Email já cadastrado";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
}

