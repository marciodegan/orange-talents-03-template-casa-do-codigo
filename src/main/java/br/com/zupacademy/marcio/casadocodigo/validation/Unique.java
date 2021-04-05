package br.com.zupacademy.marcio.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

    String message() default "Já existe um(a) idêntico(a) a este(a)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
