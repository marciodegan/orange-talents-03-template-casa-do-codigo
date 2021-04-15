package br.com.zupacademy.marcio.casadocodigo.validation;

import javax.persistence.EntityManager;

import br.com.zupacademy.marcio.casadocodigo.controller.dto.ClienteRequest;
import br.com.zupacademy.marcio.casadocodigo.model.Pais;
import br.com.zupacademy.marcio.casadocodigo.model.Estado;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class EstadoPertenceAPaisValidator implements Validator {

    private EntityManager manager;

    public EstadoPertenceAPaisValidator(EntityManager manager) {
        super();
        this.manager = manager;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        ClienteRequest request = (ClienteRequest) target;

        if (request.temEstado()) {
            Pais pais = manager.find(Pais.class, request.getPaisId());
            Estado estado = manager.find(Estado.class, request.getEstadoId());
            if (!estado.pertenceAPais(pais)) {
                errors.rejectValue("idEstado", null, "este estado não é o do país selecionado");
            }
        }
    }
}