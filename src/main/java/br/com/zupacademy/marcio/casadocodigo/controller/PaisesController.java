package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.controller.dto.PaisRequest;
import br.com.zupacademy.marcio.casadocodigo.controller.dto.PaisResponse;
import br.com.zupacademy.marcio.casadocodigo.model.Pais;
import br.com.zupacademy.marcio.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisesController {

    private PaisRepository paisRepository;

    public PaisesController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @GetMapping
    public List<Pais> listar() {
        return paisRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<PaisResponse> cadastrar(@RequestBody @Valid PaisRequest paisRequest){
        return ResponseEntity.ok(new PaisResponse(paisRepository.save(paisRequest.converter())));
    }

}