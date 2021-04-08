package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.controller.dto.EstadoRequest;
import br.com.zupacademy.marcio.casadocodigo.controller.dto.EstadoResponse;
import br.com.zupacademy.marcio.casadocodigo.model.Estado;
import br.com.zupacademy.marcio.casadocodigo.repository.EstadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadosController {

    private EstadoRepository estadoRepository;

    public EstadosController(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.findAll();
        }


    @PostMapping
    public ResponseEntity<EstadoResponse> cadastrar(@RequestBody @Valid EstadoRequest estadoRequest) {
        return ResponseEntity.ok(new EstadoResponse(estadoRepository.save(estadoRequest.converter())));
    }
}

