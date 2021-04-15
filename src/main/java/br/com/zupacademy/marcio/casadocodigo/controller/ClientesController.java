package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.controller.dto.ClienteRequest;
import br.com.zupacademy.marcio.casadocodigo.model.Cliente;

import br.com.zupacademy.marcio.casadocodigo.validation.EstadoPertenceAPaisValidator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    @PersistenceContext
    private EntityManager manager;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoPertenceAPaisValidator);
    }

    @PostMapping
    @Transactional
    public String cria(@RequestBody @Valid ClienteRequest request) {

        Cliente novoCliente = request.toModel(manager);
        manager.persist(novoCliente);

        return novoCliente.toString();
    }

}
